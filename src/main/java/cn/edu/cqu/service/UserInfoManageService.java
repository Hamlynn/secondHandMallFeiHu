package cn.edu.cqu.service;

import cn.edu.cqu.entity.User;
import cn.edu.cqu.entity.common_vo.ResultVo;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoManageService {
    ResultVo changeUserInfo(User user);

    ResultVo lookUpUserInfoByUserId(Integer id);
}
