package com.bjpowernode.service;

import com.bjpowernode.domain.City;
import com.bjpowernode.domain.Province;

import java.util.List;

/**
 *
 */
public interface ProvinceCityService {

    List<Province> queryAllProvince();

    int addCity(City city);

    List<City> queryCityByProvinceId(Integer provinceId);
}
