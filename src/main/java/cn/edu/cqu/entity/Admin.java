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
 * 管理员
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
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    @TableId(value = "a_Id", type = IdType.AUTO)
    private Long aId;

    /**
     * 账号
     */
    @TableField("a_Name")
    private String aName;

    /**
     * 密码
     */
    @TableField("a_Password")
    private String aPassword;


}
