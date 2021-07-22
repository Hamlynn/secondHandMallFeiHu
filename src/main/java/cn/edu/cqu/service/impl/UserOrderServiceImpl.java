package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.UserOrder;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.entity.query_vo.OrderInfoVo;
import cn.edu.cqu.mapper.UserOrderMapper;
import cn.edu.cqu.service.IProductService;
import cn.edu.cqu.service.IUserOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单  服务实现类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements IUserOrderService {

    @Resource
    private IUserOrderService iUserOrderService;

    @Resource
    private UserOrderMapper userOrderMapper;

    @Resource
    private IProductService productService;


    @Override
    public ResultVo removeOrderByOrderId(Integer orderId) {

        boolean flag=iUserOrderService.removeById(orderId);
        if(flag){
            return new ResultVo(StatusVo.OK,"删除订单成功",null);
        }
        else  return new ResultVo(StatusVo.NO,"删除订单失败",null);
    }

    @Override
    public ResultVo lookUpBuyOrder(Integer userId) {


        List<OrderInfoVo> orderInfoVoList = userOrderMapper.lookUpBuyOrder(userId);
        if (orderInfoVoList.isEmpty()) {
            return new ResultVo(StatusVo.NO, "用户还没有购买过物品", null);
        } else {
            return new ResultVo(StatusVo.OK, "查询用户购买订单成功", orderInfoVoList);
        }
    }

    @Override
    public ResultVo lookUpSellOrder(Integer userId) {
        List<UserOrder> userSellOrderList = userOrderMapper.lookUpSellOrder(userId);

        if (userSellOrderList.isEmpty()) {
            return new ResultVo(StatusVo.NO, "用户还没有售出过物品", null);
        } else {
            return new ResultVo(StatusVo.OK, "查询用户售出订单成功", userSellOrderList);
        }

    }


    //payOrder 和 processOrder待完成

    @Override
    public ResultVo payOrder(Integer orderId) {
        return null;
    }

    @Override
    public ResultVo proecssOrder(Integer orderId) {
        return null;
    }

    @Override
    public ResultVo orderCreate(UserOrder userOrder) {
        productService.updateProductStateAfterSellByPid(userOrder.getPId());
        boolean flg=iUserOrderService.save(userOrder);
        if (flg){
            return new ResultVo(StatusVo.OK,"创建订单成功!",null);
        }
        return new ResultVo(StatusVo.NO,"创建订单失败!",null);
    }

    @Override
    public ResultVo confirmReciveProduct(Integer id) {
        UserOrder userOrder=UserOrder.builder().oState(2).oId(id).build();
        boolean flg=iUserOrderService.updateById(userOrder);
        if(flg){
            return new ResultVo(StatusVo.OK,"确认收货成功",null);
        }
        return new ResultVo(StatusVo.NO,"确认收货失败",null);

    }

    @Override
    public ResultVo confirmDeliverProduct(Integer id) {
        UserOrder userOrder=UserOrder.builder().oState(1).oId(id).build();
        boolean flg=iUserOrderService.updateById(userOrder);
        if(flg){
            return new ResultVo(StatusVo.OK,"确认发货成功",null);
        }
        return new ResultVo(StatusVo.NO,"确认失败货失败",null);
    }


}
