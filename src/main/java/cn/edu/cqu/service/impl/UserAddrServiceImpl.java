package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.UserAddr;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.mapper.UserAddrMapper;
import cn.edu.cqu.service.IUserAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 收货地址 服务实现类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Service
public class UserAddrServiceImpl extends ServiceImpl<UserAddrMapper, UserAddr> implements IUserAddrService {

    @Resource
    private UserAddrMapper userAddrMapper;


    @Resource
    IUserAddrService userAddrService;

    @Override
    public ResultVo lookUpUserAddrByUserId(Integer id) {
        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("u_Id", id);
        List<UserAddr> userAddrList= userAddrMapper.selectByMap(map);
        return new ResultVo(StatusVo.OK,"查询地址信息成功",userAddrList);
    }



    @Override
    public ResultVo changeUserAddr(UserAddr userAddr) {

//        if(userAddr.getRFlag()==1){
//            //只有一个flag值能为1
//            //确保用户只有一个默认收货地址
//            Map<String, Object> map = new HashMap<>();
//            //增加查询条件,字段需要与数据库表中的字段一致
//            map.put("u_Id", userAddr.getUId());
//            List<UserAddr> userAddrList=userAddrMapper.selectByMap(map);
//            Iterator<UserAddr> iterator=userAddrList.iterator();
//            while (iterator.hasNext()){
//                UserAddr userAddr1=iterator.next();
//                if(userAddr1.getRFlag()==1){
//                    userAddr1.setRFlag(0);
//                    userAddrService.updateById(userAddr1);
//                    System.out.println(userAddr1.getRFlag());
//                };
//            }
//        }
        Boolean flg=userAddrService.updateById(userAddr);
        if (flg){
            return new ResultVo(StatusVo.OK,"修改地址信息成功",null);
        }
        return new ResultVo(StatusVo.NO,"修改地址信息失败",null);

    }

    @Override
    public ResultVo findDefaultAddrByUserId(Integer id) {
        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("u_Id", id);
        map.put("r_Flag", 1);
        List<UserAddr> userAddrList= userAddrMapper.selectByMap(map);
        Iterator<UserAddr> iterator=userAddrList.iterator();
        while (iterator.hasNext()){
            UserAddr userAddr=iterator.next();
            return new ResultVo(StatusVo.OK,"查询用户默认地址成功",userAddr);
        }
        return new ResultVo(StatusVo.NO,"用户没有设置默认地址！",null);
    }


    //前端有默认地址选项,若选择设为默认地址则flag设置1
    @Override
    public ResultVo addUserAddr(UserAddr userAddr) {

        Boolean flg=userAddrService.save(userAddr);
//        if(userAddr.getRFlag()==1){
//            //只有一个flag值能为1
//            //确保用户只有一个默认收货地址
//            Map<String, Object> map = new HashMap<>();
//            //增加查询条件,字段需要与数据库表中的字段一致
//            map.put("u_Id", userAddr.getUId());
//            List<UserAddr> userAddrList=userAddrMapper.selectByMap(map);
//            Iterator<UserAddr> iterator=userAddrList.iterator();
//            while (iterator.hasNext()){
//                UserAddr userAddr1=iterator.next();
//                if(userAddr1.getRFlag()==1){
//                    userAddr1.setRFlag(0);
//                    userAddrService.updateById(userAddr1);
//                    System.out.println(userAddr1.getRFlag());
//                };
//            }
//        }
        if(flg){
            return new ResultVo(StatusVo.OK,"添加地址成功！",null);
        }
        else return new ResultVo(StatusVo.NO,"添加地址失败！",null);




    }

    @Override
    public ResultVo deleteAddrByAddrId(Integer id) {

        //设置不能删除默认地址
        UserAddr userAddr=userAddrService.getById(id);
        boolean flg=userAddrService.removeById(id);
        if(flg){
            return new ResultVo(StatusVo.OK,"删除地址成功！",null);

        }
       else return new ResultVo(StatusVo.NO,"删除地址失败！",null);
    }


}
