package com.zz.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.zz.domain.po.Role;
import com.zz.domain.po.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by zhangz on 2017/7/18.
 */
public interface UserService {
    UserAccount getByUsername(String username);
    UserAccount getUser(Integer id);
    List<UserAccount> getAll();
    UserAccount createUser(UserAccount user);
    void deleteUser(int id);
    void updateUser(UserAccount user);
	Page<UserAccount> getSearchPage(UserAccount queryUser, Pageable pageable);
}
