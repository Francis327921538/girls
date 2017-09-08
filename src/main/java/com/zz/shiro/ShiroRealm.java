package com.zz.shiro;

import com.zz.domain.po.Permission;
import com.zz.domain.po.Role;
import com.zz.domain.po.UserAccount;
import com.zz.enums.UserAccountStateEnum;
import com.zz.service.PermissionService;
import com.zz.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        UserAccount user = userService.getByUsername((String) principals.getPrimaryPrincipal());

        //赋予角色
//        for (Role userRole : user.getRoles()) {
//            info.addRole(userRole.getRoleName());
//        }
        info.addRoles(user.getRoleNames());
        //赋予权限
        for (Permission permission : permissionService.getByRole(user.getRoles())) {
            info.addStringPermission(permission.getPermissionIdentifier());
        }
        //设置登录次数、时间
//         userService.updateUserLogin(user);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();
        UserAccount user = userService.getByUsername(username);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if(UserAccountStateEnum.LOCKED.getIndex() == user.getState()) {
            throw new LockedAccountException(); //帐号锁定
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getAccount(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
