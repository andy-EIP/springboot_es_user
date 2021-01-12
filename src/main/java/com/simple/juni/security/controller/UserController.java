package com.simple.juni.security.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.juni.security.domain.bean.User;
import com.simple.juni.security.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = "1. User")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {

	final UserService userService;

	@ApiOperation(value = "참여고객 조회" , notes = "참여고객을 조회한다.")
	@ApiImplicitParams({
		@ApiImplicitParam(
			name = "userId",
			value = "참여고객 고유 아이디",
			required = true,
			dataType = "string",
			paramType = "path",
			defaultValue = "juni_cbl_user_1"),
	})
	@GetMapping(value = "/{userId}")
	public User findUser(
		@PathVariable(value="userId") String userId) throws Exception {
		return userService.loadUser(userId);
	}

	@GetMapping(value = "/users")
	public List<User> allUsers() throws Exception {
		return userService.loadAllUsers();
	}
}
