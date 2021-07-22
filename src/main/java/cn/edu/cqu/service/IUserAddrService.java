package cn.edu.cqu.service;

import cn.edu.cqu.entity.UserAddr;
import cn.edu.cqu.entity.common_vo.ResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 收货地址 服务类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
public interface IUserAddrService extends IService<UserAddr> {
    ResultVo lookUpUserAddrByUserId(Integer id);

    ResultVo changeUserAddr(UserAddr userAddr);

    ResultVo findDefaultAddrByUserId(Integer id);

    ResultVo addUserAddr(UserAddr userAddr);

    ResultVo deleteAddrByAddrId(Integer id);
}
