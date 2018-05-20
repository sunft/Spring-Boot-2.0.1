package com.sunft.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sunft on 2018/5/16.
 * Blog控制器
 */
@Controller
@RequestMapping("blogs")
public class BlogController {

    /**
     * 首页博客进行搜索
     * @param order 排序规则为new
     * @param keyword 标签,关键字
     * @return 重定向到首页
     */
    @GetMapping
    public String listBlogs(@RequestParam(value = "order", required = false, defaultValue = "new") String order,
                            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) {
        System.out.println("order:" + order + ";keyword:" + keyword);
        return "redirect:/index?order=" + order + "&keyword=" + keyword;
    }

}
