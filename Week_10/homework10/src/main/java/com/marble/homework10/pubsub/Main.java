

package com.marble.homework10.pubsub;

import redis.clients.jedis.JedisPool;


public class Main {

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        String channelName = "ORDER";

        SubscribeOrder subscribeOrder = new SubscribeOrder(jedisPool, channelName);
        PublishOrder publishOrder = new PublishOrder(jedisPool, channelName);
    }
}
