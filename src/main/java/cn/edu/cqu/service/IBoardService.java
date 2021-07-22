package cn.edu.cqu.service;

import cn.edu.cqu.entity.Board;
import cn.edu.cqu.entity.common_vo.ResultVo;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 公告板  服务类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
public interface IBoardService extends IService<Board> {

    //列出所有公告板
    ResultVo listAllBoard();

    //增加公告板
    ResultVo saveBoard(Board board);

    //更新公告板
    ResultVo updateBoard(Board board);

    //根据Id移除公告板
    ResultVo removeBoard(Integer boardId);

    //根据Id查询公告板
    ResultVo getBoardById(Integer boardId);

}
