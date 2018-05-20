package com.sunft.blog.controller;

import com.sunft.blog.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunft on 2018/5/1.
 */
@RestController
public class MediaTypeController {

    /**
     * 根据客户端请求的 Content-Type，响应相应的 UserVO 类型.
     *
     * @return
     */
    @RequestMapping("/user")
    public User getUser() {
        return new User("sunft", 30);
    }

}
