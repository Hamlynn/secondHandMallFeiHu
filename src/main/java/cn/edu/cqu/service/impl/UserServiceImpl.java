package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.User;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.mapper.UserMapper;
import cn.edu.cqu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.naming.Name;
import java.util.*;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private  IUserService userService;

    @Resource
    private UserMapper userMapper;

    private StatusVo statusVo;


    /**
     * 以下是与用户登录有关的登录、注册、忘记密码服务实现
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public ResultVo checkLogin(String name, String pwd) {
        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("u_Name", name);
        List<User> userList= userMapper.selectByMap(map);
        //迭代器遍历list
        Iterator<User> iterator=userList.iterator();
        //不允许相同用户名存在
        while (iterator.hasNext()){
            User user=iterator.next();
            if(user.getUPassword().equals(pwd)){
               JwtBuilder jwtBuider= Jwts.builder();
               HashMap<String,Object> hashMap=new HashMap<>();
               hashMap.put("u_Name",user.getUName());
               String token=jwtBuider.setSubject(user.getUName()) //主题就是token中携带的数据
               .setIssuedAt(new Date()) //设置token的生成时间
               .setId(""+user.getUId())
               .setClaims(hashMap)//map中可以存放用户的角色与权限信息
                       //设置token的过期时间
               .setExpiration(new Date(System.currentTimeMillis()+24*60*60*1000))
               .signWith(SignatureAlgorithm.HS256,"feihu")   //设置加密方式与密码
               .compact();  //生成字符串
                return new ResultVo(statusVo.OK,token,userList);
            }
        }


        return new ResultVo(statusVo.NO,"用户名或密码错误",null);

    }

    @Override
    public ResultVo register(User user) {
        //如果数据库中已经存在该用户名则不允许注册
        List<User> userList=userService.list();
        Iterator<User> iterator=userList.iterator();
        while(iterator.hasNext()){
            User user1=iterator.next();
            if(user1.getUName().equals(user.getUName())){
                return new ResultVo(statusVo.NO,"当前用户名已存在!",null);
            }
        }
        boolean flg=userService.save(user);
        if (flg) {

            return new ResultVo(statusVo.OK,"注册成功",null);
        }
        else {

            return new  ResultVo(statusVo.NO,"因数据库原因注册失败!",null);
        }
        }



    @Override
    public ResultVo checkUserPhone(Map<String, Object> userinfo) {
        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("u_Name", userinfo.get("uname"));
        List<User> userList= userMapper.selectByMap(map);
        Iterator<User> iterator=userList.iterator();
        while(iterator.hasNext()){
            User user1=iterator.next();
            if(user1.getUPhonenum().equals(userinfo.get("uphonenum"))){
                return new ResultVo(statusVo.OK,"用户输入了正确的手机！",null);
            }
        }
        return new ResultVo(statusVo.NO,"用户输入的手机号不正确",null);
    }

    @Override
    public ResultVo changePasswordByUserName(Map<String, Object> userinfo) {
        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("u_Name", userinfo.get("uname"));
        List<User> userList= userMapper.selectByMap(map);
        Iterator<User> iterator=userList.iterator();
        while(iterator.hasNext()){
            User user=iterator.next();
            user.setUPassword((String) userinfo.get("upassword"));
            boolean flg=userService.updateById(user);
            if (flg){
                return new ResultVo(statusVo.OK,"修改密码成功！",null);
            }
            else return new ResultVo(statusVo.NO,"修改密码失败！",null);
        }

        return  new ResultVo(statusVo.NO,"修改密码失败！",null);

    }

}
