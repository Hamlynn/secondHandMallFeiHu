package cn.edu.cqu.service;

import cn.edu.cqu.entity.Store;
import cn.edu.cqu.entity.common_vo.ResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 收藏 服务类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
public interface IStoreService extends IService<Store> {


    //将商品添加到收藏
    ResultVo addProductToStore(Store store);


    ResultVo lookUpStoreByUserId(Integer id);
    ResultVo deleteStoreByStoreId(Integer id);

}
