package com.zz.service;

import com.zz.domain.po.Role;

import java.util.List;
import java.util.Set;


/**
 * Created by zhangz on 2017/7/18.
 */
public interface RoleService {
    public List<Role> getAll();
    public void createRole(Role role);
	public void createRole(Role role, Set<Integer> permIds, Set<Integer> menuIds);
	public void update(Role role, Set<Integer> permIds, Set<Integer> menuIds);
    public  Role findById(Integer id);
	public void deleteRole(int id);
}
