package com.example.homework03.api.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}