package com.zz.domain.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * Created by zhangz on 2017/9/1.
 */
public class QueryObject<T> implements Serializable {

    private static final long serialVersionUID = 3498069042388751294L;
    @Value("${query-object.page}")
    private int page;
    @Value("${query-object.size}")
    private int size;
    private String index;
    private String direction;
    private T entity;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "QueryObject{" +
                "page=" + page +
                ", size=" + size +
                ", index='" + index + '\'' +
                ", direction='" + direction + '\'' +
                ", entity=" + entity +
                '}';
    }
}
