package com.zz.repository;

import com.zz.domain.po.Permission;
import com.zz.domain.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Set;

/**
 * Created by zhangz on 2017/7/18.
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    Set<Permission> findByRoles(Set<Role> roles);

}
