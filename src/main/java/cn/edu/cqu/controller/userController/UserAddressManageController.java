package cn.edu.cqu.controller.userController;


import cn.edu.cqu.entity.UserAddr;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.service.IUserAddrService;
import cn.edu.cqu.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userAddrManage")
@Api(value="提供用户地址信息管理接口",tags = "用户地址管理")
@CrossOrigin
public class UserAddressManageController {
    @Resource
    private IUserAddrService userAddrService;


    @ApiOperation(value = "查看用户所有地址信息接口",notes = "查找用户所有地址信息")
    @GetMapping("/lookUpUserAddrByUserId/{id}")
    public ResultVo lookUpUserAddrByUserId(@PathVariable("id") Integer id){
       ResultVo resultVo=userAddrService.lookUpUserAddrByUserId(id);
        return resultVo;
    }

    @ApiOperation(value = "改变用户收货地址信息接口",notes = "改变用户地址信息")
    @PostMapping("/changeUserAddr")
    public ResultVo changeUserAddr(@RequestBody UserAddr userAddr){
        ResultVo resultVo=  userAddrService.changeUserAddr(userAddr);
        return  resultVo;
    }

    @ApiOperation(value = "查找用户默认地址信息接口",notes = "获取用户默认地址信息")
    @GetMapping("/findDefaultAddrByUserId/{id}")
    public ResultVo findDefaultAddrByUserId(@PathVariable("id") Integer id){
        ResultVo resultVo=userAddrService.findDefaultAddrByUserId(id);
        return resultVo;
    }

    @ApiOperation(value = "添加用户收货地址接口",notes = "添加用户收货地址")
    @PostMapping("/addUserAddr")
    public ResultVo addUserAddr(@RequestBody UserAddr userAddr){
        ResultVo resultVo= userAddrService.addUserAddr(userAddr);
        return  resultVo;
    }

    @ApiOperation(value = "删除用户收货地址接口",notes = "删除用户收货地址")
    @GetMapping("/deleteAddrByAddrId/{id}")
    public ResultVo deleteAddrByAddrId(@PathVariable("id") Integer id){
       ResultVo resultVo=userAddrService.deleteAddrByAddrId(id);
        return resultVo;
    }

}
