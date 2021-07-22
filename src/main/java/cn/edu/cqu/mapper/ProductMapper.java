package cn.edu.cqu.mapper;

import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.query_vo.ProductDetailVo;
import cn.edu.cqu.entity.query_vo.WaterfallVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 商品 Mapper 接口
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    List<WaterfallVo> lookUpWaterfallProduct();

    List<ProductDetailVo>lookUpProductDetail();

    ProductDetailVo lookUpProductDetailByPid(Integer id);

    List<ProductDetailVo> listProductByCname(String cname);
    List<ProductDetailVo>  listProductByPriceRange(int price_low, int price_high);

    List<ProductDetailVo> listProductByViewNumRange(int viewNum_low, int viewNum_high);

    int lookMaxIdInProduct();

    List<ProductDetailVo> lookUpProductInfoByPname(String pname);
}
