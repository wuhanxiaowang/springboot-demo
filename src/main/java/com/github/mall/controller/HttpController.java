package com.github.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.mall.common.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HttpController
 * @Description TODO
 * @Author 王炎
 * @Date 2019/10/9 11:41
 * @ModifyDate 2019/10/9 11:41
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/restTemplate")
public class HttpController {
    final static String URL_POST = "http://localhost:8888/contract/getContractDetailInfo";
    //无参数
    final static String URL_GET_NO_PARAMS = "http://localhost:8888/contract/test";
    //有参数
    final static String URL_GET_HASH_PARAMS = "http://localhost:8888/contract/test?name={name}";
    @Autowired
    RestTemplate restTemplate;

    /**
     * postForObject和postForEntity区别就是,postForEntity返回ResponseEntity<T>封装一些信息
     *
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public ApiResult testPost() {
        //第一种,面向对象
        /*ContractCommonVo contractCommonVo=new ContractCommonVo();
        contractCommonVo.setEntrustId(17L);
        contractCommonVo.setContractNo("2019-02-CP0001");
        contractCommonVo.setContractType("1");*/
        // HttpEntity<ContractCommonVo> httpEntity=new HttpEntity(contractCommonVo,httpHeaders);

        //第二种,JSON
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("contractNo", "2019-02-CP0001");
        jsonObject.put("contractType", "1");
        jsonObject.put("entrustId", 17L);
        //HttpEntity<JSONObject> httpEntity=new HttpEntity(jsonObject,httpHeaders);

        //第三种,MultiValueMap(使用RestTemplate发送multipart/form-data格式的数据)
       /* MultiValueMap<String,Object> multiValueMap=new LinkedMultiValueMap<>();
        multiValueMap.add("contractNo","2019-02-CP0001");
        multiValueMap.add("contractType","1");
        multiValueMap.add("entrustId",17L);*/
        //httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //HttpEntity<MultiValueMap<String,Object>> httpEntity=new HttpEntity<>(multiValueMap,httpHeaders);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", "110");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject, httpHeaders);
        try {
            ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(URL_POST, httpEntity, JSONObject.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                log.info("===============" + responseEntity.getBody());
            }
        } catch (RestClientException e) {
            log.info("=============" + e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
        return ApiResult.success("ok");
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ApiResult testGet() {
        JSONObject forObject = null;
        try {
            //无参数
            // ResponseEntity<JSONObject> entity = restTemplate.getForEntity(URL_GET_NO_PARAMS, JSONObject.class);
            //  log.info("=================================="+entity.getBody());
            // 有参数
            Map<String, Object> map = new HashMap<>();
            map.put("name", "wy");
            ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(URL_GET_HASH_PARAMS, JSONObject.class, map);
            log.info("===========" + forEntity.getBody());
        } catch (RestClientException e) {
            return ApiResult.failed(e.getMessage());
        }
        return ApiResult.success("ok");
    }

    @RequestMapping(value = "/exchange", method = RequestMethod.GET)
    public ApiResult testExchange() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "wy");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", "110");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        try {
            ResponseEntity<JSONObject> exchange = restTemplate.exchange(URL_GET_HASH_PARAMS, HttpMethod.GET, httpEntity, JSONObject.class, map);
            log.info("==============" + exchange.getBody());
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return ApiResult.success("ok");
    }


}
