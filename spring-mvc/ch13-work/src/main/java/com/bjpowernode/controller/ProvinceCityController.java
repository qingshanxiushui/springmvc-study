package com.bjpowernode.controller;

import com.bjpowernode.domain.City;
import com.bjpowernode.domain.Province;
import com.bjpowernode.service.ProvinceCityService;
import com.bjpowernode.vo.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Controller
public class ProvinceCityController {

    @Resource
    private ProvinceCityService service;

    //查询所有的省份
    @RequestMapping("/queryProvince.do")
    @ResponseBody
    public CommonResult queryProvinces(){
        List<Province> list = service.queryAllProvince();

        CommonResult cr  = new CommonResult(1,"查询没有结果","");;
        if( list !=null && list.size()>0){
            cr =  new CommonResult(0,"查询成功",list);
        }

        return cr;
    }

    //添加城市
    @RequestMapping("/city/addCity.do")
    @ResponseBody
    public CommonResult addCity(City city){
        int rows = service.addCity(city);
        CommonResult cr  = new CommonResult();
        if( rows > 0){
            cr.setCode(0);
            cr.setMsg("添加城市"+city.getName()+"成功");
            cr.setData(city);
        } else {
            cr.setCode(1);
            cr.setMsg("添加城市失败");
            cr.setData("");
        }
        return cr;
    }


    //查询城市
    @RequestMapping("/city/queryCity.do")
    @ResponseBody
    public CommonResult queryCity(Integer pid){

        List<City> cityList = service.queryCityByProvinceId(pid);

        CommonResult cr  = new CommonResult();
        if( cityList !=null && cityList.size() > 0 ){
            cr.setCode(0);
            cr.setMsg("查询出"+cityList.size()+"个城市");
            cr.setData(cityList);
        } else {
            cr.setCode(1);
            cr.setMsg("查询无结果");
            cr.setData("");
        }
        return cr;
    }
}
