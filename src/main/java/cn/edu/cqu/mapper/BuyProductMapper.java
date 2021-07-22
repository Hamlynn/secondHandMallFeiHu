package cn.edu.cqu.mapper;

import cn.edu.cqu.entity.BuyProduct;
import cn.edu.cqu.entity.query_vo.BuyInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 求购商品信息 Mapper 接口
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Mapper
public interface BuyProductMapper extends BaseMapper<BuyProduct> {

    List<BuyInfoVo> lookUpAllBuyInfo();
}
