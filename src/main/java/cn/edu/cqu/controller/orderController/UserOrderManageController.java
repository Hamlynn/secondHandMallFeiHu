package cn.edu.cqu.controller.orderController;


import cn.edu.cqu.entity.UserOrder;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.service.IUserOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderManage")
@Api(value="提供订单管理接口",tags = "用户订单管理")
@CrossOrigin
public class UserOrderManageController {

    @Resource
    IUserOrderService userOrderService;

    @PostMapping("/deleteOrderById/{orderId}")
    @ApiOperation(value = "删除订单接口",notes = "post方式，按照订单id删除订单")
    public ResultVo removeOrderByOrderId(@PathVariable("orderId") Integer orderId){
        ResultVo resultVo=userOrderService.removeOrderByOrderId(orderId);
        return resultVo;
    }

    @GetMapping("/lookUpBuyOrder/{userId}")
    @ApiOperation(value="查询用户购买商品订单接口",notes ="get方式，根据用户ID查询用户购买物品订单")
    public  ResultVo lookUpBuyOrder(@PathVariable("userId") Integer userId){

        ResultVo resultVo=userOrderService.lookUpBuyOrder(userId);
        return resultVo;
    }

    @GetMapping("/confirmReciveProduct/{id}")
    @ApiOperation(value="确认收货接口",notes ="get方式，发送订单id")
    public  ResultVo confirmReciveProduct(@PathVariable("id") Integer id){
        ResultVo resultVo=userOrderService.confirmReciveProduct(id);
        return resultVo;
    }


    @GetMapping("/confirmDeliverProduct/{id}")
    @ApiOperation(value="确认发货接口",notes ="get方式，发送订单id")
    public  ResultVo confirmDeliverProduct(@PathVariable("id") Integer id){
        ResultVo resultVo=userOrderService.confirmDeliverProduct(id);
        return resultVo;
    }



    @GetMapping("/lookUpSellOrder/{userId}")
    @ApiOperation(value="查询用户售出商品订单接口",notes ="get方式，根据用户ID查询用户售出物品订单")
    public  ResultVo lookUpSellOrder(@PathVariable("userId") Integer userId){
        ResultVo resultVo=userOrderService.lookUpSellOrder(userId);
        return resultVo;
    }

    @PostMapping("/orderCreate")
    @ApiOperation(value="创建订单接口",notes ="post方式，发送订单对象")
    public  ResultVo orderCreate(@RequestBody UserOrder userOrder){
        ResultVo resultVo=userOrderService.orderCreate(userOrder);
        return resultVo;
    }


}
