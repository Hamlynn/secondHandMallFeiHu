package cn.edu.cqu.service;

import cn.edu.cqu.entity.Admin;
import cn.edu.cqu.entity.User;
import cn.edu.cqu.entity.common_vo.ResultVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
public interface IAdminService extends IService<Admin> {

    //管理员登录
    ResultVo checkLogin(String name, String pwd);


}
