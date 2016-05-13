package com.chj.common.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chj.common.api.base.ErrorResponse;
import com.chj.common.api.base.ResponseData;

@Controller
@RequestMapping("test")
public class TestResource implements BaseResource {

	@RequestMapping(value = "getUser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ApiOperation(value = "添加用户", httpMethod = "POST", response = ResponseData.class, notes = "add user")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid Account ID supplied"), @ApiResponse(code = 404, message = "Account not found"), @ApiResponse(code = 500, response = ErrorResponse.class, message = "Server Error") })
	@ResponseBody
	public ResponseData addUser(@ApiParam(required = true, name = "postData", value = "用户信息json数据") @RequestParam(value = "postData") String postData, HttpServletRequest request) {
		return ResponseData.getSuccess("this is a test data!!!");
	}

}
