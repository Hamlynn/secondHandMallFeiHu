package cn.edu.cqu.mapper;

import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.ShoppingcarProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 加入购物车商品 Mapper 接口
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Mapper
public interface ShoppingcarProductMapper extends BaseMapper<ShoppingcarProduct> {
    public List<Product> lookUpShoppingCarByUserId(Integer id);

}
