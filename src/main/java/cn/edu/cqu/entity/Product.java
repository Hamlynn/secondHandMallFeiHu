package cn.edu.cqu.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品
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
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "p_Id", type = IdType.AUTO)
    private Long pId;

    /**
     * 商品名称
     */
    @TableField("p_Name")
    private String pName;

    /**
     * 卖家用户id
     */
    @TableField("seller_Id")
    private Long sellerId;

    /**
     * 商品描述
     */
    @TableField("p_Intro")
    private String pIntro;

    /**
     * 商品图片
     */
    @TableField("p_Img")
    private String pImg;

    /**
     * 商品分类
     */
    @TableField("c_Id")
    private Long cId;

    /**
     * 商品价格
     */
    @TableField("p_Price")
    private BigDecimal pPrice;

    /**
     * 商品状态
     */
    @TableField("p_State")
    private Integer pState;

    /**
     * 商品发布时间
     */
    @TableField("p_Time")
    private LocalDateTime pTime;

    /**
     * 商品浏览量
     */
    @TableField("p_ViewNum")
    private Integer pViewNum;
}
