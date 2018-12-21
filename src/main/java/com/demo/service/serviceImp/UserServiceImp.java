package com.demo.service.serviceImp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dao.UserMapper;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo() {
        User user = userMapper.selectByName("王五");
        return user;
    }

    public void addUser() {
        User user = new User();
        user.setId("2");
        user.setUsername("王五");
        user.setAge(21L);
        user.setUserphone(13111111111L);
        userMapper.insert(user);
        System.out.print("增加成功!");
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    public Page<User> selectUserPage(Page<User> page){
        return page.setRecords(userMapper.selectUserList(page));
    }


}
