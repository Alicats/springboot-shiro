package cn.xej.service;

import cn.xej.pojo.User;

import java.util.List;

public interface UserService {

    public User findByUserId(String userId);

    public List<String> getRolesIdByUserId(String userId);
}
