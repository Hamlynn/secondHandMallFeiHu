package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.Admin;
import cn.edu.cqu.entity.User;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.mapper.AdminMapper;
import cn.edu.cqu.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Resource
    private IAdminService adminService;

    @Resource
    private AdminMapper adminMapper;

    @Override
    public ResultVo checkLogin(String name, String pwd) {
        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("a_Name", name);
        List<Admin> adminList= adminMapper.selectByMap(map);
        //迭代器遍历list
        Iterator<Admin> iterator=adminList.iterator();
        //不允许相同用户名存在
        while (iterator.hasNext()){
            Admin admin=iterator.next();
            if(admin.getAPassword().equals(pwd)){
                JwtBuilder jwtBuider= Jwts.builder();
                HashMap<String,Object> hashMap=new HashMap<>();
                hashMap.put("a_Name",admin.getAName());
                String token=jwtBuider.setSubject(admin.getAName()) //主题就是token中携带的数据
                        .setIssuedAt(new Date()) //设置token的生成时间
                        .setId(""+admin.getAId())
                        .setClaims(hashMap)//map中可以存放用户的角色与权限信息
                        //设置token的过期时间
                        .setExpiration(new Date(System.currentTimeMillis()+24*60*60*1000))
                        .signWith(SignatureAlgorithm.HS256,"feihu")   //设置加密方式与密码
                        .compact();  //生成字符串
                return new ResultVo(StatusVo.OK,token,adminList);
            }
        }


        return new ResultVo(StatusVo.NO,"用户名或密码错误",null);
    }

}
