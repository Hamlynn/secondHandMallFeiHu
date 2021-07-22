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
 * 公告板
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
public class Board implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公告id
     */
    @TableId(value = "board_Id", type = IdType.AUTO)
    private Long boardId;

    /**
     * 公告内容
     */
    @TableField("board_Text")
    private String boardText;

    /**
     * 创建时间
     */
    @TableField("board_Time")
    private LocalDateTime boardTime;

    /**
     * 管理员id
     */
    @TableField("a_Id")
    private String aId;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    private LocalDateTime updatedTime;


}
