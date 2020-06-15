package com.chinasoft.controller;


import com.chinasoft.model.User;
import com.chinasoft.service.UsersService;
import com.chinasoft.vo.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@Api(description = "接口", value = "接口" ,protocols = "JSON")
@ResponseBody
@RequestMapping("/v1/user" )
@RestController
@EnableAutoConfiguration
public class UserController {


    @Autowired
    private UsersService usersService;


    @ApiOperation(value = "登录", httpMethod = "POST",notes = "登录")
    @ApiResponses({   @ApiResponse(code = 404,message = "链接错误")})
    @PostMapping(value = "/login")
    public ResponseData login(@RequestParam("user")String user,@RequestParam("password")String password ){
       int status = usersService.login(user,password);
       if(status ==-1){
           ResponseData responseData = ResponseData.unauthorized();
           responseData.putDataValue("data", "账号密码填写错误");
           return responseData;
       }else{
           ResponseData responseData = ResponseData.ok();
           responseData.putDataValue("data", "登录成功");
           return responseData;
       }
    }


    @ApiOperation(value = "注册", httpMethod = "POST",notes = "注册")
    @ApiResponses({   @ApiResponse(code = 404,message = "链接错误")})
    @PostMapping(value = "/reg")
    public ResponseData reg(@RequestBody User user ){
        int status = usersService.reg(user);
        if(status ==-1){
            ResponseData responseData = ResponseData.unauthorized();
            responseData.putDataValue("data", "账号已被注册");
            return responseData;
        }else{
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("data", "注册成功，请前往登录");
            return responseData;
        }
    }

}
