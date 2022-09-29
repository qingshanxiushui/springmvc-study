package com.bjpowernode.service.impl;

import com.bjpowernode.dao.CityDao;
import com.bjpowernode.dao.ProvinceDao;
import com.bjpowernode.domain.City;
import com.bjpowernode.domain.Province;
import com.bjpowernode.service.ProvinceCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class ProvinceCityServiceImpl implements ProvinceCityService {

    @Resource
    private ProvinceDao pdao;
    @Resource
    private CityDao cdao;

    @Override
    public List<Province> queryAllProvince() {
        return pdao.selectProvinceList();
    }

    @Override
    public int addCity(City city) {

        int rows = cdao.insertCity(city);
        return rows;
    }

    @Override
    public List<City> queryCityByProvinceId(Integer provinceId) {
        return cdao.selectCityByProvinceId(provinceId);
    }
}
