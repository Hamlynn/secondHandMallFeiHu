package cn.edu.cqu.controller.userController;


import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/releaseProductManage")
@Api(value="提供用户商品发布管理的接口",tags = "用户商品发布管理")
@CrossOrigin
public class ReleaseProductManageController {
    @Resource
    private IProductService productService;

    @PostMapping("/releaseProduct")
    @ApiOperation(value = "发布商品",notes = "输入商品对象")
    public ResultVo releaseProduct(@RequestBody Product product){
        ResultVo resultVo=productService.releaseProduct(product);
        return resultVo;
    }

    @ApiOperation(value = "更改商品信息",notes = "输入商品对象")
    @PostMapping("/changeProductInfo")
    public ResultVo changeProductInfo(@RequestBody Product product){
        ResultVo resultVo=productService.changeProductInfo(product);
        return resultVo;
    }
    @ApiOperation(value = "下架商品",notes = "根据商品id下架商品")
    @GetMapping("/deleteReleasedProductByPid/{id}")
    public ResultVo deleteReleasedProductByPid(@PathVariable("id") Integer id){
        ResultVo resultVo=productService.deleteReleasedProductByPid(id);
        return resultVo;
    }

    @ApiOperation(value = "查看当前用户所发布商品",notes = "根据用户id查看当前用户所发布商品")
    @GetMapping("/lookUpReleasedProductByUid/{id}")
    public  ResultVo lookUpReleasedProductByUid(@PathVariable("id")Integer id){
        ResultVo resultVo=productService.lookUpReleasedProductByUid(id);
        return resultVo;
    }

}
