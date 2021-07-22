package cn.edu.cqu.controller.userController;

import cn.edu.cqu.entity.BuyProduct;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.service.IBuyProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/wantingInfoManage")
@Api(value="提供用户管理求购信息接口",tags = "用户求购信息管理")
@CrossOrigin
public class WantingInfoManageController {

    @Resource
    private IBuyProductService buyProductService;

    @ApiOperation(value = "用户发布全部信息接口",notes = "用户发布全部信息接口",httpMethod = "GET")
    @PostMapping("/releaseBuyInfo")
    public ResultVo releaseBuyInfo(@RequestBody BuyProduct buyProduct){
        ResultVo resultVo=buyProductService.releaseBuyInfo(buyProduct);
        return  resultVo;
    }

    @ApiOperation(value = "用户改变求购信息接口",notes = "用户发布改变求购信息接口",httpMethod = "POST")
    @PostMapping("/changeBuyInfo")
    public ResultVo changeBuyInfo(@RequestBody BuyProduct buyProduct){
        ResultVo resultVo=buyProductService.changeBuyInfo(buyProduct);
        return resultVo;
    }

    @ApiOperation(value = "用户删除求购信息接口",notes = "用户发布改变求购信息接口",httpMethod = "GET")
    @GetMapping("/deleteBuyInfoByBuyId/{id}")
    public ResultVo deleteBuyInfoByBuyId(@PathVariable("id") Integer id){
        ResultVo resultVo=buyProductService.deleteBuyInfoByBuyId(id);
        return resultVo;
    }

    @ApiOperation(value = "查看当前用户求购信息接口",notes = "用户发布改变求购信息接口",httpMethod = "GET")
    @GetMapping("/lookUpBuyInfoByUserId/{id}")
    public ResultVo lookUpBuyInfoByUserId(@PathVariable("id") Integer id){
        ResultVo resultVo=buyProductService.lookUpBuyInfoByUserId(id);
        return resultVo;
    }

    @ApiOperation(value = "查看所有用户求购信息接口",notes = "用户发布改变求购信息接口",httpMethod = "GET")
    @GetMapping("/lookUpAllBuyInfo")
    public ResultVo lookUpAllBuyInfo(){
        ResultVo resultVo=buyProductService.lookUpAllBuyInfo();
        return resultVo;
    }


}
