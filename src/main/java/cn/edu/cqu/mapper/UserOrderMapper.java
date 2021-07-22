package cn.edu.cqu.mapper;

import cn.edu.cqu.entity.UserOrder;
import cn.edu.cqu.entity.query_vo.OrderInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 订单  Mapper 接口
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Mapper
public interface UserOrderMapper extends BaseMapper<UserOrder> {

    OrderInfoVo lookUpDetailedOrderInfoById(Integer orderId);

    List<OrderInfoVo> lookUpDetailedOrderInfoByBuyerId(Integer buyerId);

    List<OrderInfoVo> lookUpBuyOrder(Integer userId);


    List<UserOrder> lookUpSellOrder(Integer userId);
}
