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
 * 收藏
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
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏id
     */
    @TableId(value = "store_Id", type = IdType.AUTO)
    private Integer storeId;

    /**
     * 用户id
     */
    @TableField("u_Id")
    private Integer uId;

    /**
     * 商品id
     */
    @TableField("p_Id")
    private Integer pId;

    /**
     * 收藏时间
     */
    @TableField("store_Time")
    private LocalDateTime storeTime;


}
