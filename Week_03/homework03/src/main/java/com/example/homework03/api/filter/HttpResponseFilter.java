package com.example.homework03.api.filter;

import io.netty.handler.codec.http.FullHttpResponse;
import okhttp3.Request;
import okhttp3.Response;

public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

    void filter(FullHttpResponse response, Response resp);
}
