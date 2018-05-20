package com.sunft.blog.repository.es;

import com.sunft.blog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by sunft on 2018/5/5.
 * EsBlog的Repository接口
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    /**
     * 根据标题、摘要或者内容分页查询EsBlog，查询过程中去掉重复的
     *
     * @param title    标题
     * @param content  内容
     * @param pageable 分页对象
     * @return 分页集
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);

}
