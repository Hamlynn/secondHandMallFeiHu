package cn.edu.cqu.mapper;

import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 收藏 Mapper 接口
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Mapper
public interface StoreMapper extends BaseMapper<Store> {
        public List<Product> lookUpStoreProductByUserId(Integer id);
}
