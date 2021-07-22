package cn.edu.cqu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 收货地址
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
public class UserAddr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地址id
     */
    @TableId(value = "r_Id", type = IdType.AUTO)
    private Integer rId;

    /**
     * 用户id
     */
    @TableField("u_Id")
    private Integer uId;

    /**
     * 具体地址
     */
    @TableField("r_ReciverAddress")
    private String rReciveraddress;

    /**
     * 标志
     */
    @TableField("r_Flag")
    private Integer rFlag;

    /**
     * 收货人姓名
     */
    @TableField("r_ReceiverName")
    private String rReceivername;

    /**
     * 收货人电话
     */
    @TableField("r_ReceiverPhone")
    private String rReceiverphone;

    /**
     * 收货人省份
     */
    @TableField("r_Province")
    private String rProvince;

    /**
     * 收货人城市
     */
    @TableField("r_City")
    private String rCity;

    /**
     * 收货人地区
     */
    @TableField("r_Area")
    private String rArea;
}
