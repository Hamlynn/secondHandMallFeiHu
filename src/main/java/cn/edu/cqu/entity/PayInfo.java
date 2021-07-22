package cn.edu.cqu.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayInfo {
    //订单ID
    String orderId;
    //付款金额，必填
    String  orderPrice;
    //订单名称，必填
    String  orderName;
    //商品描述，可空
    String  orderDescribe;
}
