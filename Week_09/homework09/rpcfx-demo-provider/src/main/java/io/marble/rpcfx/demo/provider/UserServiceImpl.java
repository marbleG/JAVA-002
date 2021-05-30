package io.marble.rpcfx.demo.provider;

import io.marble.rpcfx.demo.api.User;
import io.marble.rpcfx.demo.api.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
