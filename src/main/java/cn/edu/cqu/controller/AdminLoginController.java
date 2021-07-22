package cn.edu.cqu.controller;


import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.service.IAdminService;
import cn.edu.cqu.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/adminLogin")
@Api(value="提供管理员的登录接口",tags = "管理员登录管理")
@CrossOrigin
public class AdminLoginController {
    @Resource
    private IAdminService adminService;


    @GetMapping("/login/{name}/{pwd}")
    @ApiOperation(value = "进行登录判断接口",notes = "输入name,pwd返回resultVo对象",httpMethod = "GET")
    public ResultVo checkLogin(@PathVariable("name") String name, @PathVariable("pwd") String pwd){
        ResultVo resultVo=adminService.checkLogin(name,pwd);
        return resultVo;
    }
}
