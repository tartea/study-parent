package org.tartea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tartea.entity.User;


public interface UserMapper extends BaseMapper<User> {

    Integer countRecord();

    Integer isExistRecord(String name);

}
