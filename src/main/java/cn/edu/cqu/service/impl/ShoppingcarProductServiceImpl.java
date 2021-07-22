package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.ShoppingcarProduct;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.mapper.ShoppingcarProductMapper;
import cn.edu.cqu.service.IShoppingcarProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 加入购物车商品 服务实现类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Service
public class ShoppingcarProductServiceImpl extends ServiceImpl<ShoppingcarProductMapper, ShoppingcarProduct> implements IShoppingcarProductService {

    @Resource
   private IShoppingcarProductService  shoppingcarProductService;

    @Resource
   private ShoppingcarProductMapper shoppingcarProductMapper;



    @Override
    public ResultVo addProductToShoppingCar(ShoppingcarProduct shoppingcarProduct) {

        boolean flag=shoppingcarProductService.save(shoppingcarProduct);
        if(flag){
            return new ResultVo(StatusVo.OK,"添加商品到购物车成功",null);
        }else{
            return new ResultVo(StatusVo.NO,"添加商品到购物车失败",null);
        }

    }


    @Override
    public ResultVo lookUpShoppingCarByUserId(Integer id) {
        List<Product> productList=shoppingcarProductMapper.lookUpShoppingCarByUserId(id);
        //现查用户收藏的商品，再根据pid查商品信息
        if (productList!=null){
            return  new ResultVo(StatusVo.OK,"查询用户购物车成功",productList);
        }
        return  new ResultVo(StatusVo.NO,"当前用户购物车没有商品!",null);
    }

    @Override
    public ResultVo deleteShoppingCarProductBySpId(Integer id) {

        boolean flg=shoppingcarProductService.removeById(id);

        if(flg){
            return new ResultVo(StatusVo.OK,"购物车商品删除成功!",null);
        }
        else return new ResultVo(StatusVo.NO,"购物车商品删除失败!",null);
    }
}
