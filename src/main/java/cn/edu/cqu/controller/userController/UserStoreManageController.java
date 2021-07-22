package cn.edu.cqu.controller.userController;


import cn.edu.cqu.entity.Store;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.service.IStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/userStoreManage")
@Api(value="提供用户管理收藏接口",tags = "用户收藏管理")
@CrossOrigin
public class UserStoreManageController {

    @Resource
    private IStoreService storeService;

    @PostMapping("/addProductToStore")
    @ApiOperation(value = "向收藏内增加商品接口",notes = "POST方式，时间格式应为:2020-09-07T00:00:00Z")
    public ResultVo addProductToStore(@RequestBody Store store){
        ResultVo resultVo=storeService.addProductToStore(store);
        return resultVo;
    }


    @ApiOperation(value = "用户收藏查看接口",notes = "通过用户id查看用户所有的收藏商品",httpMethod = "GET")
    @GetMapping("/lookUpStoreByUserId/{id}")
    public ResultVo lookUpStoreByUserId(@PathVariable("id") Integer id){
        ResultVo resultVo=storeService.lookUpStoreByUserId(id);
        return resultVo;
    }

    @ApiOperation(value = "用户删除收藏商品接口",notes = "通过收藏商品s_id删除商品",httpMethod = "GET")
    @GetMapping("/deleteStoreByStoreId/{id}")
    public ResultVo deleteStoreByStoreId(@PathVariable("id") Integer id){
        ResultVo resultVo=storeService.deleteStoreByStoreId(id);
        return resultVo;
    }



}
