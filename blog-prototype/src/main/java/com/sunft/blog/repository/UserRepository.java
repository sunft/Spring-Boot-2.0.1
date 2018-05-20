package com.sunft.blog.repository;

import com.sunft.blog.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sunft on 2018/4/21.
 * 用户接口
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
