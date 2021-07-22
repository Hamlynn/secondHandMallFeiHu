package cn.edu.cqu.service;

import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.ShoppingcarProduct;
import cn.edu.cqu.entity.Store;
import cn.edu.cqu.entity.common_vo.ResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
public interface IProductService extends IService<Product> {


    //列出所有商品
    ResultVo listAllProduct();

    //根据组合条件查询商品
    ResultVo listProductByCombinedCondition();

    //根据分类查询商品
    ResultVo listProductByCategory(Integer categoryId);

    //查看某个单独商品
    ResultVo lookUpProductById(Integer productId);



    ResultVo releaseProduct(Product product);

    ResultVo changeProductInfo(Product product);

    ResultVo deleteReleasedProductByPid(Integer id);

    ResultVo lookUpReleasedProductByUid(Integer id);

    ResultVo lookUpWaterfallProduct();


    ResultVo lookUpProductDetail();

    ResultVo lookUpProductDetailByPid(Integer id);

    ResultVo listProductByCname(String cname);

    ResultVo listProductByPriceRange(int price_low, int price_high);

    ResultVo listProductByViewNumRange(int viewNum_low, int viewNum_high);

    ResultVo updateProductStateAfterSellByPid(Long id);


    ResultVo lookMaxIdInProduct();

    ResultVo lookUpProductInfoByPname(String pname);
}
