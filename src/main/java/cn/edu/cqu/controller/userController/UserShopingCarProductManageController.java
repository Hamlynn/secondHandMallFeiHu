package cn.edu.cqu.controller.userController;


import cn.edu.cqu.entity.ShoppingcarProduct;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.service.IShoppingcarProductService;
import cn.edu.cqu.service.IStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userShoppingManage")
@Api(value="提供用户管理购物车接口",tags = "用户购物车管理")
@CrossOrigin
public class UserShopingCarProductManageController {

    @Resource
    private IShoppingcarProductService shoppingcarProductService;

    @PostMapping("/addProductToShoppingCar")
    @ApiOperation(value = "向购物车内增加商品",notes = "POST方式，时间格式应为:2020-09-07T00:00:00Z")
    public ResultVo addProductToShoppingCar(@RequestBody ShoppingcarProduct shoppingcarProduct){
        ResultVo resultVo=shoppingcarProductService.addProductToShoppingCar(shoppingcarProduct);
        return resultVo;
    }


    @ApiOperation(value = "用户查看购物车商品接口",notes = "通过用户id查看用户所有的购物车商品",httpMethod = "GET")
    @GetMapping("/lookUpShoppingCarByUserId/{id}")
    public ResultVo lookUpShoppingCarByUserId(@PathVariable("id") Integer id){
        ResultVo resultVo=shoppingcarProductService.lookUpShoppingCarByUserId(id);
        return resultVo;
    }

    @ApiOperation(value = "删除购物车商品接口",notes = "通过购物车商品sp_id删除购物车商品",httpMethod = "GET")
    @GetMapping("/deleteShoppingCarProductBySpId/{id}")
    public ResultVo deleteStoreByStoreId(@PathVariable("id") Integer id){
        ResultVo resultVo=shoppingcarProductService.deleteShoppingCarProductBySpId(id);
        return resultVo;
    }

}
