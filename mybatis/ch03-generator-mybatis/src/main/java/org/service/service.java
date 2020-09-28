package org.service;

import org.dao.NewsMapper;
import org.pojo.News;

public class service {
    private NewsMapper newsMapper;

    public NewsMapper getNewsMapper() {
        return newsMapper;
    }

    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }
    public News selectById(int id){
        return newsMapper.selectByPrimaryKey(id);
    }
}
