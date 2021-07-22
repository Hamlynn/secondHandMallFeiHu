package cn.edu.cqu.service;

import cn.edu.cqu.entity.User;
import cn.edu.cqu.entity.common_vo.ResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
public interface IUserService extends IService<User> {
    ResultVo checkLogin(String name,String pwd);
    ResultVo register(User user);


    ResultVo checkUserPhone(Map<String, Object> userinfo);

    ResultVo changePasswordByUserName(Map<String, Object> userinfo);
}
