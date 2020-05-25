package cn.xej.service.impl;

import cn.xej.mapper.UserDao;
import cn.xej.pojo.User;
import cn.xej.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserId(String userId) {

        return userDao.findByUserId(userId);
    }

    @Override
    public List<String> getRolesIdByUserId(String userId) {
        return userDao.queryRolesIdByUserId(userId);
    }
}
