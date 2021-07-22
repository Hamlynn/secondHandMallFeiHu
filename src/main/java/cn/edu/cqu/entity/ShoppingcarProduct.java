package cn.edu.cqu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 加入购物车商品
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
public class ShoppingcarProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车商品id
     */
    @TableId(value = "sp_Id", type = IdType.AUTO)
    private Long spId;

    /**
     * 购物车对应用户id
     */
    @TableField("u_Id")
    private Long uId;

    /**
     * 商品id
     */
    @TableField("p_Id")
    private Long pId;



    /**
     * 商品加入时间
     */
    @TableField("sp_AddTime")
    private LocalDateTime spAddTime;

}
