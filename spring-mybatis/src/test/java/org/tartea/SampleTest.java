package org.tartea;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tartea.entity.User;
import org.tartea.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testQuery() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> userList = userMapper.selectList(queryWrapper);
        Assert.assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testCount() {
        Integer record = userMapper.countRecord();
        Assert.assertSame(1, record);
    }

    @Test
    public void updateData() {
        User user = new User();
        user.setName("wen");
        user.setAge(12);
        user.setEmail("12312312@qq.com");
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("user_id", 2);
        int update = userMapper.update(user, updateWrapper);
        System.out.println(update);
    }


    /**
     * 存在多条数据的时候会报错
     */
    //    @Test
    public void selectList() {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("name", "wen");
        User user = userMapper.selectOne(updateWrapper);
        System.out.println(user.toString());
    }

}
