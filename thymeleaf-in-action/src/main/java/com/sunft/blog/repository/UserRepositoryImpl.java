package com.sunft.blog.repository;

import com.sunft.blog.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sunft on 2018/4/21.
 * 用户操作实现类
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    //用于统计用户数和区分用户id
    private static AtomicLong counter = new AtomicLong();

    //模拟数据库
    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>(0);

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        //id为空,说明是新增操作
        if (id == null){
            //获取用户id
            id = counter.incrementAndGet();
            user.setId(id);
        }
        //模拟保存数据
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> listUser() {
        //注意该方法的使用
        return new ArrayList<User>(this.userMap.values());
    }

}
