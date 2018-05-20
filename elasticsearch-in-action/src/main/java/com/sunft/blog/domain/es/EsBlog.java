package com.sunft.blog.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by sunft on 2018/5/5.
 * 博客实体类
 */
@Document(indexName = "blog", type = "blog", shards = 1, replicas = 0, refreshInterval = "-1") //标识这是一个文档
@XmlRootElement // MediaType 转为 XML
public class EsBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id  // 主键
    private String id;
    private String title;
    private String summary;
    private String content;

    public EsBlog() {

    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
                "EsBlog[id = '%s', title='%s', summary='%s', content='%s']",
                this.id, this.title, this.summary, this.content
        );
    }

}
