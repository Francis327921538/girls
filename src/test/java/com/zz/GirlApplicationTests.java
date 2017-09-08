package com.zz;

import com.zz.domain.po.Role;
import com.zz.domain.po.UserAccount;
import com.zz.domain.po.UserDetail;
import com.zz.repository.RoleRepository;
import com.zz.repository.UserRepository;
import com.zz.service.UserService;
import com.zz.service.EmailSender;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {

	@Resource
	private UserService userService;
	@Resource
	private UserRepository userRepository;
	@Resource
	private RoleRepository roleRepository;
	@Autowired
	private EmailSender emailSender;
	@Test
	public void contextLoads() {

	}

	@Test
	public void testUser() {
//		for (int i = 0; i < 200; i++) {
//			userService.createUser(new UserAccount("zz" + i, "0000", new UserDetail("user" + i, (short)0, "13116315056")));
//		}

		Role role1 = new Role();
		role1.setId(1);
//		Role role2 = new Role();
//		role2.setId(2);
//		Role role3 = new Role();
//		role3.setId(3);
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findOne(1));
		UserAccount userAccount = new UserAccount("zz", "0000");
		userAccount.setEmail("");
		userAccount.setRoles(roles);
		UserDetail userDetail = new UserDetail();
		userDetail.setUsername("");
		userDetail.setGender((short)0);
		userDetail.setPhone("");
		userAccount.setUserDetail(userDetail);
		Pageable pageable = new PageRequest(0,10);
		userService.getSearchPage(userAccount, pageable).getContent().forEach(in -> {
			System.out.println(in.getAccount());
		});
//		System.out.println(userRepository.findOne(1).getRoleNames());
//		Role role1 = new Role();
//		role1.setId(1);
//		Role role2 = new Role();
//		role2.setId(2);
//		Role role3 = new Role();
//		role3.setId(3);
//		List<Role> roles = new ArrayList<>();
//		roles.add(role1);
////		roles.add(role2);
////		roles.add(role3);
//		System.out.println(userRepository.findByRolesIn(roles));
	}

	@Test
	public void testEmail() {
		String[] strings = {"327921538@qq.com"};
		emailSender.prepareAndSend("zhangzheng@wservice.com.cn", strings, "sadasd", null);
	}
	@Test
	public void testMail() {

	}
}
