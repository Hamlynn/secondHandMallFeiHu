package cn.edu.cqu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "o_Id", type = IdType.AUTO)
    private Integer oId;

    /**
     * 订单创建时间
     */
    @TableField("o_Time")
    private LocalDateTime oTime;

    /**
     * 订单状态
     */
    @TableField("o_State")
    private Integer oState;

    /**
     * 商品id
     */
    @TableField("p_Id")
    private Long pId;

    /**
     * 买家用户id
     */
    @TableField("buyer_Id")
    private Long buyerId;


    /**
     * 订单编号
     */
    @TableField("o_Num")
    private String oNum;

    /**
     * 买家用户地址id
     */
    @TableField("buyer_AddrId")
    private Long buyerAddrId;


}
