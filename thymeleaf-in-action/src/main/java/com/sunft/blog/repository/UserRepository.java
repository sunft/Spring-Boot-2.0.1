package com.sunft.blog.repository;

import com.sunft.blog.domain.User;

import java.util.List;

/**
 * Created by sunft on 2018/4/21.
 * 用户接口
 */
public interface UserRepository {

    /**
     * 创建或者修改用户
     * @param user 用户对象
     * @return 用户信息
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     */
    void deleteUser(Long id);

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 用户信息
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * @return 用户列表信息
     */
    List<User> listUser();

}
