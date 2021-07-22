package cn.edu.cqu.controller.userController;

import cn.edu.cqu.entity.User;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/userLogin")
@Api(value="提供用户的登录和注册接口",tags = "用户登录管理")
@CrossOrigin
public class UserLoginController {

    @Resource
    private IUserService userService;
    private StatusVo statusVo;

    @GetMapping("/login/{name}/{pwd}")
    @ApiOperation(value = "进行登录判断接口",notes = "输入name,pwd返回resultVo对象",httpMethod = "GET")
    public ResultVo checkLogin(@PathVariable("name") String name, @PathVariable("pwd") String pwd){
        ResultVo resultVo=userService.checkLogin(name,pwd);
        return resultVo;
    }
    @PostMapping("/register")
    @ApiOperation("用户注册接口")
    public ResultVo register(@RequestBody User user){
        ResultVo resultVo=userService.register(user);
        return  resultVo;
    }

    @PostMapping("/changePasswordByUserName")
    @ApiOperation(value = "用户更改密码接口",notes = "传入userinfo对象，包括uname,upassword")
    public ResultVo changePasswordByUserName(@RequestBody Map<String,Object> userinfo){
        ResultVo resultVo=userService.changePasswordByUserName(userinfo);
        return resultVo;
    }

    @PostMapping("/checkUserPhone")
    @ApiOperation(value = "核对用户手机信息接口",notes = "传入userinfo对象，包括uname,uphonenum")
    public ResultVo checkUserPhone(@RequestBody Map<String,Object> userinfo){
        ResultVo resultVo=userService.checkUserPhone(userinfo);
        return resultVo;
    }



}
