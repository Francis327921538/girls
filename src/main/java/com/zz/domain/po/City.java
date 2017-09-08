package com.zz.domain.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 城市实体类
 *
 * Created by bysocket on 03/05/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "city")
@Document(indexName = "dbgril", type = "city")
public class City implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * 城市编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceid;

    /**
     * 城市名称
     */
    private String cityname;

    /**
     * 描述
     */
    private String description;

}
