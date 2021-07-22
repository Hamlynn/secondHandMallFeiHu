package cn.edu.cqu.service;

import cn.edu.cqu.entity.ShoppingcarProduct;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 加入购物车商品 服务类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
public interface IShoppingcarProductService extends IService<ShoppingcarProduct> {

    //向购物车内增加商品
    ResultVo addProductToShoppingCar(ShoppingcarProduct shoppingcarProduct);

    ResultVo lookUpShoppingCarByUserId(Integer id);

    ResultVo deleteShoppingCarProductBySpId(Integer id);
}
