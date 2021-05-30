package io.marble.rpcfx.api;

public interface Filter {

    boolean filter(RpcfxRequest request);

    // Filter next();

}
