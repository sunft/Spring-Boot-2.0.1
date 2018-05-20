package com.sunft.blog.repository.es;

import com.sunft.blog.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sunft on 2018/5/5.
 * 测试EsBlogRepository
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    /**
     * 初始化数据
     */
    @Before
    public void initRepositoryData() {
        //1、清除所有数据
        esBlogRepository.deleteAll();
        //2、初始化数据
        esBlogRepository.save(new EsBlog("登鹳雀楼", "王之涣的登鹳雀楼", "白日依山尽，黄河入海流。欲穷千里目，更上一层楼"));
        esBlogRepository.save(new EsBlog("相思","王维的相思","红豆生南国，春来发几枝。愿君多采撷，此物最相思。"));
        esBlogRepository.save(new EsBlog("静夜思","李白的静夜思","床前明月光，疑是地上霜。举头望明月，低头思故乡。"));

    }


    /**
     * 测试方法
     */
    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        //1、初始化参数
        //从0开始，返回20条数据
        Pageable pageable = PageRequest.of(0, 20);
        String title = "思";
        String summary = "相思";
        String content = "相思";

        //2、进行测试
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);

        //3、循环遍历结果
        System.out.println("---------------------start");
        for (EsBlog blog : page.getContent()) {
            System.out.println(blog);
        }
        System.out.println("----------------------end");
    }

}
