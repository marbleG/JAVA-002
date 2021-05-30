package io.marble.rpcfx.api;

public interface RpcfxResolver {

    <T> T resolve(Class<T> aClass);

}
