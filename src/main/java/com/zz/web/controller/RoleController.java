package com.zz.web.controller;

import com.zz.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by zhangz on 2017/9/4.
 */
@RestController
@RequestMapping("/role")
public class RoleController extends ResultController {

    @Resource
    private RoleService roleService;

    @GetMapping("/page")
    public Map<String, Object> page() {
        return resultMap(true, roleService.getAll());
    }
}
