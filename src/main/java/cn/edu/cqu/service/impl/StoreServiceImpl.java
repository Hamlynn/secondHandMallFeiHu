package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.Store;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.mapper.StoreMapper;
import cn.edu.cqu.service.IStoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 收藏 服务实现类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements IStoreService {

    @Resource
    private IStoreService iStoreService;
    @Resource
    private StoreMapper StoreMapper;

    @Override
    public ResultVo addProductToStore(Store store) {

        boolean flag=iStoreService.save(store);
        if(flag){
            return new ResultVo(StatusVo.OK,"添加商品到收藏成功",null);
        }else{
            return new ResultVo(StatusVo.NO,"添加商品到收藏失败",null);
        }
    }



    @Override
    public ResultVo lookUpStoreByUserId(Integer id) {
        List<Product> productList=StoreMapper.lookUpStoreProductByUserId(id);

        //现查用户收藏的商品，再根据pid查商品信息
        if (productList!=null){
            return  new ResultVo(StatusVo.OK,"查询用户收藏成功",productList);
        }
        return  new ResultVo(StatusVo.NO,"当前用户没有收藏",null);
    }

    @Override
    public ResultVo deleteStoreByStoreId(Integer id) {
        boolean flg=iStoreService.removeById(id);

        if(flg){
            return new ResultVo(StatusVo.OK,"用户收藏商品删除成功!",null);
        }
        else return new ResultVo(StatusVo.NO,"用户收藏商品删除失败!",null);
    }


}
