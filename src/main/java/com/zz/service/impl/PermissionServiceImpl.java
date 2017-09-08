package com.zz.service.impl;

import com.zz.domain.po.Permission;
import com.zz.domain.po.Role;
import com.zz.repository.PermissionRepository;
import com.zz.service.PermissionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;
import java.util.Set;

/**
 * Created by zhangz on 2017/7/18.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    private @Resource
    PermissionRepository permissionRepository;

    @Override
    public void deletePermission(int id) {
        System.out.println(id);
        Permission permission = permissionRepository.findOne(id);
        System.out.println(permission.getChildren());
        permission.getParent().getChildren().remove(permission);
        permission.setParent(null);
        permission.setRoles(null);
        permissionRepository.delete(permission);
    }

    @Override
    public void createPermission(Permission permission) {
        Permission parent = permissionRepository.findOne(permission.getParent().getId());
        permission.setParent(parent);
        System.out.println(permission.getId());
        permissionRepository.save(permission);
    }

    @Override
    public Set<Permission> getAll() {
        return permissionRepository.findOne(1).getChildren();
    }

    @Override
    public Set<Permission> getByRole(Set<Role> roles) {
        return permissionRepository.findByRoles(roles);
    }

	@Override
	public void updatePermission(Permission permission) {
		Permission perm = permissionRepository.findOne(permission.getId());
		perm.setPermissionIdentifier(permission.getPermissionIdentifier());
		perm.setPermissionName(permission.getPermissionName());
        permissionRepository.saveAndFlush(perm);
	}
}
