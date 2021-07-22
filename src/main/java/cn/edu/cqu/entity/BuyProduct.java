package cn.edu.cqu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 求购商品信息
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
public class BuyProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 求购商品id
     */
    @TableId(value = "buy_Id", type = IdType.AUTO)
    private Long buyId;

    /**
     * 求购商品名称
     */
    @TableField("buy_ProductName")
    private String buyProductName;

    /**
     * 求购商品描述
     */
    @TableField("buy_Intro")
    private String buyIntro;

    /**
     * 求购用户id
     */
    @TableField("buy_BuyerId")
    private Long buyBuyerId;

    /**
     * 发布时间
     */
    @TableField("buy_Time")
    private LocalDateTime buyTime;

    /**
     * 求购商品相似图
     */
    @TableField("buy_Img")
    private String buyImg;

    /**
     * 求购商品
     */
    @TableField("buy_Phone")
    private String buyPhone;


}
