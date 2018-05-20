package com.sunft.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sunft on 2018/5/16.
 * 用户主页空间控制器
 */
@Controller
@RequestMapping("/u")
public class UserspaceController {

    /**
     * 如果访问的是用户名，则跳转到用户主页
     *
     * @param username 用户名
     * @return 跳转到用户主页
     */
    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username) {
        System.out.println("username" + username);
        return "/userspace/u";
    }

    /**
     * 访问用户博客
     * @param username 用户名
     * @param order 排序方式
     * @param category 分类
     * @param keyword 关键字
     * @return
     */
    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value = "order", required = false, defaultValue = "new") String order,
                                   @RequestParam(value = "category", required = false) Long category,
                                   @RequestParam(value = "keyword", required = false) String keyword) {

        if (!StringUtils.isEmpty(category)) {

            System.out.print("category:" + category);
            System.out.print("selflink:" + "redirect:/userspace/u/" + username + "/blogs?category=" + category);
            return "/userspace/u";

        } else if (!StringUtils.isEmpty(keyword)) {

            System.out.print("keyword:" + keyword);
            System.out.print("selflink:" + "redirect:/userspace/u/" + username + "/blogs?keyword=" + keyword);
            return "/userspace/u";
        }

        System.out.print("order:" + order);
        System.out.print("selflink:" + "redirect:/userspace/u/" + username + "/blogs?order=" + order);
        return "/userspace/u";
    }

    /**
     * 查看博客
     * @param id 博客id
     * @return
     */
    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id) {

        System.out.print("blogId:" + id);
        return "/userspace/blog";
    }

    /**
     * 编辑博客
     * @return
     */
    @GetMapping("/{username}/blogs/edit")
    public String editBlog() {

        return "/userspace/blogedit";
    }

}
