package com.example.homework03.api.filter;

import io.netty.handler.codec.http.FullHttpResponse;
import okhttp3.Response;

public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("kk", "java-1-nio");
    }

    @Override
    public void filter(FullHttpResponse response, Response resp) {
        response.headers().set("true-host",resp.request().url().host());
        response.headers().set("true-port",resp.request().url().port());
    }
}
