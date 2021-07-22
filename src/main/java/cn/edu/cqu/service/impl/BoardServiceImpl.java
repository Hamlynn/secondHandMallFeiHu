package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.Board;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.mapper.BoardMapper;
import cn.edu.cqu.service.IBoardService;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 公告板  服务实现类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Service
public class BoardServiceImpl extends ServiceImpl<BoardMapper, Board> implements IBoardService {

    @Resource
    private IBoardService boardService;

    @Resource
    private BoardMapper boardMapper;

    private StatusVo statusVo;


    @Override
    public ResultVo listAllBoard() {
        List<Board> boardList=boardService.list();
        if(boardList.isEmpty()){
            return new ResultVo(StatusVo.NO,"还没有发布过公告",null);
        }else{
            return new ResultVo(StatusVo.OK,"查询所有公告成功",boardList);
        }
    }

    @Override
    public ResultVo saveBoard(Board board) {

        boolean flag=boardService.save(board);
        if(flag){
            return new ResultVo(StatusVo.OK,"添加公告成功",null);
        }else{
            return new ResultVo(StatusVo.NO,"添加公告失败",null);
        }
    }

    @Override
    public ResultVo updateBoard(Board board) {
        boolean flag=boardService.updateById(board);
        if(flag){
            return new ResultVo(StatusVo.OK,"更新公告成功",null);
        }else{
            return new ResultVo(StatusVo.NO,"更新公告失败",null);
        }
    }

    @Override
    public ResultVo removeBoard(Integer boardId) {
        int flag=boardMapper.deleteById(boardId);
        if(flag==1){
            return new ResultVo(StatusVo.OK,"移除公告成功",null);
        }else{
            return new ResultVo(StatusVo.NO,"移除公告失败",null);
        }
    }

    @Override
    public ResultVo getBoardById(Integer boardId) {
        Board board=boardService.getById(boardId);
        if(board==null){
            return new ResultVo(StatusVo.OK,"查找公告失败，当前公告不存在",null);
        }else{
            return new ResultVo(StatusVo.NO,"查找公告成功",board);
        }
    }
}
