package cn.edu.cqu.controller.userController;


import cn.edu.cqu.entity.Board;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.service.IBoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/boardManage")
@Api(value="提供公告板管理接口",tags = "公告板管理")
@CrossOrigin
public class BoardMangeController {
    @Resource
    private IBoardService boardService;

    @GetMapping("/listAllBoard")
    @ApiOperation(value = "管理员查看所有公告板信息",notes = "GET方式，直接查询")
    public ResultVo listAllBoard(){
        ResultVo resultVo=boardService.listAllBoard();
        return resultVo;
    }

    @PostMapping("/addBoard")
    @ApiOperation(value = "管理员增加公告板信息",notes = "post方式,输入的日期格式需要为:2020-09-07T00:00:00Z")
    public ResultVo addBoard(@RequestBody Board board){
        ResultVo resultVo=boardService.saveBoard(board);
        return resultVo;
    }

    @PostMapping("/updateBoard")
    @ApiOperation(value="管理员修改公告板信息",notes = "post方式")
    public ResultVo updateBoard(@RequestBody Board board){
        ResultVo resultVo=boardService.updateBoard(board);
        return  resultVo;
    }

    @GetMapping("/removeBoardById/{boardId}")
    @ApiOperation(value="管理员删除公告板信息",notes = "get方式，根据boardId删除")
    public ResultVo removeBoardById(@PathVariable("boardId") Integer boardId){
        ResultVo resultVo=boardService.removeBoard(boardId);
        return  resultVo;
    }

    @GetMapping("/lookUpBoardById/{boardId}")
    @ApiOperation(value="管理员查询公告板信息",notes = "get方式，根据boardId查询")
    public ResultVo lookUpBoardById(@PathVariable("boardId")Integer boardId){
        ResultVo resultVo=boardService.getBoardById(boardId);
        return  resultVo;
    }






}
