package com.zz.repository;

import java.util.List;

import com.zz.domain.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by zhangz on 2017/7/18.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
	List<Role> findByNameContaining(String roleName);
	
	
}
