package com.zz.web.controller;

import com.zz.domain.dto.QueryObject;
import com.zz.domain.po.UserAccount;
import com.zz.service.UserService;
import lombok.extern.java.Log;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by zhangz on 2017/9/1.
 */
@Log
@RestController
@RequestMapping("/user")
public class UserController extends ResultController {

    @Resource
    private UserService userService;

    @PostMapping("/page")
    public Map<String, Object> page(@RequestBody QueryObject<UserAccount> queryUser) {
        log.info(queryUser.toString());
        Pageable pageable = new PageRequest(queryUser.getPage(), queryUser.getSize(), new Sort(Sort.Direction.valueOf(queryUser.getDirection()), queryUser.getIndex()));
        return resultMap(true, userService.getSearchPage(queryUser.getEntity(), pageable));
    }

    @DeleteMapping(value = "/{id}/delete")
    public Map<String, Object> delete(@PathVariable int id) {
        userService.deleteUser(id);
        return resultMap(true, "删除成功！");
    }

    public static void main(String[] args) {
        System.out.println(Sort.Direction.valueOf("DESC"));
    }
}
