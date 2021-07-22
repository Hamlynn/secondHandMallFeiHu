package cn.edu.cqu.mapper;

import cn.edu.cqu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
