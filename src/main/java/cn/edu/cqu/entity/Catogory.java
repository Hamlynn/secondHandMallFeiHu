package cn.edu.cqu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品分类目录
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
public class Catogory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品分类id
     */
    @TableId(value = "c_Id", type = IdType.AUTO)
    private Long cId;

    /**
     * 分类名
     */
    @TableField("c_Name")
    private String cName;




}
