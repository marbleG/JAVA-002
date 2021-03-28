package com.example.homework02;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpClient01 {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient build = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:8805");
        CloseableHttpResponse execute = build.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        InputStream content = entity.getContent();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(content, StandardCharsets.UTF_8))) {
            System.out.println("请求结果：" + reader.readLine());
        }
    }
}
