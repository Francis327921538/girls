package com.zz.repository;

import com.zz.domain.po.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bysocket on 17/05/2017.
 */
public interface CityRepository extends ElasticsearchRepository<City,Long> {


}
