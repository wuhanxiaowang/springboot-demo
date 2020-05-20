package com.github.mall.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName httpClientUtils
 * @Description TODO
 * @Author 王炎
 * @Date 2019/10/8 19:33
 * @ModifyDate 2019/10/8 19:33
 * @Version 1.0
 */
@Slf4j
public class httpClientUtils {
    public static String sendSms(String url, JSONObject jsonObject) {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {
            StringEntity stringEntity = new StringEntity(jsonObject.toString());
            stringEntity.setContentType("application/json");
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                String s = EntityUtils.toString(httpResponse.getEntity());
                JSONObject sobj = new JSONObject();
                sobj = JSONObject.parseObject(s);
                String status = sobj.getString("status");
                String message = sobj.getString("message");
                String data = sobj.getString("data");
                log.info("----------------" + data);
                if ("0".equals(status)) {
                    result += "发送成功";
                    JSONObject jsonObject1 = JSONObject.parseObject(data);
                    log.info("==========================================" + jsonObject1.getString("coinType"));
                } else {
                    result += "失败信息" + message;
                }
            } else {
                result += "发送失败" + httpResponse.getStatusLine().getStatusCode();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            result += e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            result += e.getMessage();
        }


        return result;
    }


}
