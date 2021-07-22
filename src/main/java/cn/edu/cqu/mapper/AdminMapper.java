package cn.edu.cqu.mapper;

import cn.edu.cqu.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

/**
 * <p>
 * 管理员 Mapper 接口
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
