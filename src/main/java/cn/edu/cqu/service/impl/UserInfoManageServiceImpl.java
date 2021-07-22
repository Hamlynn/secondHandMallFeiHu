package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.User;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.mapper.UserMapper;
import cn.edu.cqu.service.IUserService;
import cn.edu.cqu.service.UserInfoManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Service
public class UserInfoManageServiceImpl implements UserInfoManageService {

    @Resource
    private IUserService userService;
    @Resource
    private UserMapper userMapper;



    @Override
    public ResultVo changeUserInfo(User user) {
        boolean flg=userService.updateById(user);
        if(flg){
            return new ResultVo(StatusVo.OK,"修改成功",null);
        }
        else  return new ResultVo(StatusVo.NO,"修改失败",null);
    }

    @Override
    public ResultVo lookUpUserInfoByUserId(Integer id) {
        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("u_Id", id);
        List<User> userList= userMapper.selectByMap(map);

        if(userList!=null){
            return new ResultVo(StatusVo.OK,"查询用户信息成功",userList);
        }

        else  return new ResultVo(StatusVo.NO,"查询用户信息失败",null);
    }






}
