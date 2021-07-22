package cn.edu.cqu.controller.productController;


import cn.edu.cqu.entity.Catogory;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.service.ICatogoryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/productManage")
@Api(value="提供商品分类目录管理接口",tags = "商品分类管理")
@CrossOrigin
public class CatogoryController {

    @Resource
    private ICatogoryService iCatogoryService;

    @GetMapping("/lookUpAllCatogory")
    public ResultVo lookUpAllCatogory(){
        List<Catogory> catogoryList=iCatogoryService.list();
        return new ResultVo(StatusVo.OK,"查询所有分类信息成功",catogoryList);
    }

    @GetMapping("/addCatogory/{catogoryName}")
    public ResultVo addCatogory(@PathVariable("catogoryName")String catogoryName ){
        Catogory catogory1=Catogory.builder().cName(catogoryName).build();
        boolean flg=iCatogoryService.save(catogory1);
        if(flg){
            return new ResultVo(StatusVo.OK,"添加分类成功",null);
        }
        return new ResultVo(StatusVo.NO,"添加分类失败",null);
    }



}
