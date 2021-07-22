package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.BuyProduct;
import cn.edu.cqu.entity.UserAddr;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.entity.query_vo.BuyInfoVo;
import cn.edu.cqu.mapper.BuyProductMapper;
import cn.edu.cqu.service.IBuyProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 求购商品信息 服务实现类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Service
public class BuyProductServiceImpl extends ServiceImpl<BuyProductMapper, BuyProduct> implements IBuyProductService {

    @Resource
    private IBuyProductService buyProductService;

    @Resource BuyProductMapper buyProductMapper;

    @Override
    public ResultVo releaseBuyInfo(BuyProduct buyProduct) {

        boolean flg=buyProductService.save(buyProduct);
        if(flg){
            return new ResultVo(StatusVo.OK,"发布求购信息成功",null);
        }
       else  return new ResultVo(StatusVo.NO,"发布求购信息失败！",null);
    }

    @Override
    public ResultVo changeBuyInfo(BuyProduct buyProduct) {
        boolean flg=buyProductService.updateById(buyProduct);
        if(flg){
            return new ResultVo(StatusVo.OK,"求购信息修改成功",null);
        }
        else  return new ResultVo(StatusVo.NO,"求购信息修改失败！",null);
    }

    @Override
    public ResultVo deleteBuyInfoByBuyId(Integer id) {
        boolean flg=buyProductService.removeById(id);
        if(flg){
            return new ResultVo(StatusVo.OK,"求购信息删除成功",null);
        }
        else  return new ResultVo(StatusVo.NO,"求购信息删除失败！",null);
    }

    @Override
    public ResultVo lookUpBuyInfoByUserId(Integer id) {
        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("buy_BuyerId", id);
        List<BuyProduct> buyProductList=buyProductMapper.selectByMap(map);
        if(buyProductList!=null){
            return new ResultVo(StatusVo.OK,"查询用户求购信息成功!",buyProductList);
        }
        else  return new ResultVo(StatusVo.OK,"当前用户还未发布过求购信息!",null);
    }

    @Override
    public ResultVo lookUpAllBuyInfo() {
        List<BuyInfoVo> buyInfoVoList=buyProductMapper.lookUpAllBuyInfo();

        return new ResultVo(StatusVo.OK,"查询所有用户求购信息成功!",buyInfoVoList);
    }


}
