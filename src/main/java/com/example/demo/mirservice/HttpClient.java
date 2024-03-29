package com.example.demo.mirservice;

import com.example.demo.common.ClientResponse;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
@Component
@Log4j2
public class HttpClient {

    @Autowired
    private OkHttpClient okHttpClient;


    public ClientResponse post(String api, Object params) throws IOException {
        String paramsStr = JSON.toJSONString(params);
        Request request = (new Request.Builder())
                .url(this.createHttpUrl(api, null, paramsStr))
                .post(this.createBody(paramsStr)).build();

        return this.call(request);
    }


    public ClientResponse get(String api, Map<String, String> queryMap) throws IOException {
        HttpUrl url = this.createHttpUrl(api,queryMap,null);
        log.info(url);
        Headers headers = this.createHeaders();
        Request request = (new Request.Builder()).url(url).headers(headers).build();
        return this.call(request);
    }

    public  ClientResponse call(Request request) throws IOException {
        try (Response resp = okHttpClient.newCall(request).execute()) {
            String body = resp.body().string();
            ClientResponse response = new ClientResponse(resp.code(), resp.message(), body);
            return response;
        }
    }

    public HttpUrl createHttpUrl(String api,Map<String, String> queryMap,String paramsStr) {
        String url = api;
        HttpUrl.Builder urlBuilder = HttpUrl.parse(api).newBuilder();
        if (CollectionUtils.isEmpty(queryMap)) {
            return urlBuilder.build();
        } else {
            Iterator var8 = queryMap.entrySet().iterator();

            while(var8.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry)var8.next();
                urlBuilder.addEncodedQueryParameter((String)entry.getKey(), (String)entry.getValue());
            }
            return urlBuilder.build();
        }
    }


    public RequestBody createBody(String dataStr) {
        return RequestBody.create(dataStr, MediaType.get("application/json; charset=utf-8"));
    }


    Headers createHeaders() {
        return new Headers.Builder().add("Content-Type", "application/json; charset=utf-8").build();
    }
}
