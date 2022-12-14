package com.bjpowernode.dao;

import com.bjpowernode.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface CityDao {
    int insertCity(City city);

    List<City> selectCityByProvinceId(@Param("pid") Integer provinceId);
}
