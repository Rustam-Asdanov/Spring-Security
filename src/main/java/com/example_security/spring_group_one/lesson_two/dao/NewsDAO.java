package com.example_security.spring_group_one.lesson_two.dao;

import com.example_security.spring_group_one.lesson_two.model.News;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class NewsDAO {

    private List<News> newsList;

    {
        if(newsList == null){
            newsList = new ArrayList<>();
            Collections.addAll(
                    newsList,
                    new News(1,"Political","Mia Khalifa now president of Armenia"),
                    new News(2,"Sport","Bayern won UEFA"),
                    new News(3,"Weather","Kayf in Baku")
            );
        }
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public News getNewsById(int id){
        return newsList.stream()
                .filter(news -> news.getId()==id)
                .findFirst()
                .orElse(new News(0,"Not found","not found"));
    }

    public void deleteNewsById(int id){
        News news_rem = getNewsById(id);

        newsList.remove(news_rem);
        System.out.println("remove success");
    }

    public void updateNewsById(int id, News theNews){
           newsList.set(
                   newsList.indexOf(getNewsById(id)),
                   theNews);
    }
}
