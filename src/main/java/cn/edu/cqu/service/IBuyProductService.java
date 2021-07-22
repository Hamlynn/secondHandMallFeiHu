package cn.edu.cqu.service;

import cn.edu.cqu.entity.BuyProduct;
import cn.edu.cqu.entity.common_vo.ResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 求购商品信息 服务类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
public interface IBuyProductService extends IService<BuyProduct> {

    ResultVo releaseBuyInfo(BuyProduct buyProduct);

    ResultVo changeBuyInfo(BuyProduct buyProduct);

    ResultVo deleteBuyInfoByBuyId(Integer id);

    ResultVo lookUpBuyInfoByUserId(Integer id);

    ResultVo lookUpAllBuyInfo();
}
