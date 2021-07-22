package cn.edu.cqu.controller.userController;


import cn.edu.cqu.entity.User;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.service.IUserService;
import cn.edu.cqu.service.UserInfoManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/userInfoManage")
@Api(value="提供用户个人信息修改接口",tags = "用户个人信息管理")
@CrossOrigin
public class UserInfoManageController {

    @Resource
    private IUserService userService;

    @Resource
    private UserInfoManageService userInfoManageService;

    private StatusVo statusVo;

    @PostMapping("/changeUserInfo")
    @ApiOperation(value = "用户改变个人信息接口",notes = "post方式传入user对象")
    public ResultVo changeUserInfo(@RequestBody User user){
        ResultVo resultVo=  userInfoManageService.changeUserInfo(user);
        return  resultVo;
    }

    @GetMapping("/lookUpUserInfoByUserId/{id}")
    @ApiOperation(value = "用户查看个人信息接口",notes = "GET方式,按用户姓名查找用户信息")
    public ResultVo lookUpUserInfoByUserId(@PathVariable("id") Integer id){
        ResultVo resultVo= userInfoManageService.lookUpUserInfoByUserId(id);
        return resultVo;
    }



    @GetMapping("/lookUpAllUser")
    @ApiOperation(value = "管理员查看所有用户信息接口",notes = "GET方式,查找所有用户信息")
    public ResultVo lookUpAllUser(){
        List<User> userList=userService.list();
        return new ResultVo(statusVo.OK,"查询所有用户成功",userList);
    }







}
