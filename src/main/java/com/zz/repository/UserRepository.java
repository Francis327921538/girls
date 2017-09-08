package com.zz.repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.zz.domain.po.Role;
import com.zz.domain.po.UserAccount;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by zhangz on 2017/7/18.
 */
public interface UserRepository extends JpaRepository<UserAccount, Integer>, JpaSpecificationExecutor<UserAccount> {

    UserAccount findByAccount(String username);

    List<UserAccount> findByRolesIn(Collection<Role> roles);
    
    Page<UserAccount> findByRolesIn(Collection<Role> roles, Pageable pageable);

}
