package cn.edu.cqu.service;

import cn.edu.cqu.entity.UserOrder;
import cn.edu.cqu.entity.common_vo.ResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单  服务类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
public interface IUserOrderService extends IService<UserOrder> {

    //通过订单ID删除订单
    ResultVo removeOrderByOrderId(Integer orderId);

    //找出用户作为买家的所有订单
    ResultVo lookUpBuyOrder(Integer userId);

    //找出用户作为卖家的所有订单
    ResultVo lookUpSellOrder(Integer userId);

    //支付订单
    ResultVo payOrder(Integer orderId);

    //根据订单ID处理订单
    ResultVo proecssOrder(Integer orderId);


    ResultVo orderCreate(UserOrder userOrder);

    ResultVo confirmReciveProduct(Integer id);

    ResultVo confirmDeliverProduct(Integer id);
}
