package cn.edu.cqu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
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
@ApiModel(value = "用户",description = "用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "u_Id", type = IdType.AUTO)
    private Long uId;

    /**
     * 用户名
     */
    @TableField("u_Name")
    private String uName;

    /**
     * 登录密码
     */
    @TableField("u_Password")
    private String uPassword;

    /**
     * 手机号
     */
    @TableField("u_PhoneNum")
    private String uPhonenum;

    /**
     * 邮箱
     */
    @TableField("u_Email")
    private String uEmail;

    /**
     * 头像
     */
    @TableField("u_Head")
    private String uHead;

    /**
     * 用户学校
     */
    @TableField("u_School")
    private String uSchool;


}
