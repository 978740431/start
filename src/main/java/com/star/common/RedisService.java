package com.star.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisService {

    @Autowired(required = false)
    // Spring容器中有ShardedJedisPool就注入，反之不注入
    private ShardedJedisPool shardedJedisPool;

    private <T> T execute(Function<ShardedJedis, T> fun) {
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis = shardedJedisPool.getResource();
            return fun.callback(shardedJedis);
        } finally {
            if (null != shardedJedis) {
                // 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
    }

    /**
     * 从redis中查询数据
     * 
     * @param key
     * @return
     * @throws Exception
     */
    public String get(final String key) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callback(ShardedJedis e) {
                return e.get(key);
            }
        });
    }

    /**
     * 设置KV数据到Redis
     * 
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    public String set(final String key, final String value) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callback(ShardedJedis e) {
                return e.set(key, value);
            }
        });
    }

    /**
     * 删除一个key
     * 
     * @param key
     * @return
     */
    public Long del(final String key) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.del(key);
            }
        });
    }

    /**
     * 设置生存时间
     * 
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(final String key, final Integer seconds) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.expire(key, seconds);
            }
        });
    }

    /**
     * 设置KV数据到Redis，并且指定生存时间，单位为秒
     * 
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    public String set(final String key, final String value, final Integer seconds) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callback(ShardedJedis e) {
                String str = e.set(key, value);
                e.expire(key, seconds);
                return str;
            }
        });
    }

    /**
     * 设置一个值，hash结构
     * 
     * @param key
     * @param field
     * @param value
     * @param seconds
     * @return
     */
    public Long hset(final String key, final String field, final String value, final Integer seconds) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callback(ShardedJedis e) {
                Long l = e.hset(key, field, value);
                e.expire(key, seconds);
                return l;
            }
        });
    }

    /**
     * 从hash结构数据中获取数据
     * 
     * @param key
     * @param field
     * @return
     */
    public String hget(final String key, final String field) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callback(ShardedJedis e) {
                return e.hget(key, field);
            }
        });
    }

    /**
     * 查询所有的字段和值
     * 
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(final String key) {
        return this.execute(new Function<ShardedJedis, Map<String, String>>() {
            @Override
            public Map<String, String> callback(ShardedJedis e) {
                return e.hgetAll(key);
            }
        });
    }

    /**
     * 判断是否存在，hash结构
     * 
     * @param key
     * @param field
     * @return
     */
    public Boolean hexists(final String key, final String field) {
        return this.execute(new Function<ShardedJedis, Boolean>() {
            @Override
            public Boolean callback(ShardedJedis e) {
                return e.hexists(key, field);
            }
        });
    }

    /**
     * 添加zset 集合 保存tag数据
     * 
     * @param key ,一个商品一个key,
     * @param member 标签,性能好之类的
     * @param score 分数,自动根据分数排序
     * @return
     */
    public Long zadd(final String key, final String member, final Double score) {
        return this.execute(new Function<ShardedJedis, Long>() {

            @Override
            public Long callback(ShardedJedis e) {
                return e.zadd(key, score, member);
            }

        });
    }

    /**
     * 查询到top N 数据 从大到小
     * 
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> zrevrange(final String key, final Integer start, final Integer end) {
        return this.execute(new Function<ShardedJedis, Set<String>>() {

            @Override
            public Set<String> callback(ShardedJedis e) {
                return e.zrevrange(key, start, end);
            }

        });
    }

    /**
     * 查询到top N 数据 从小到大
     * 
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> zrange(final String key, final Integer start, final Integer end) {
        return this.execute(new Function<ShardedJedis, Set<String>>() {

            @Override
            public Set<String> callback(ShardedJedis e) {
                return e.zrevrange(key, start, end);
            }

        });
    }

    /**
     * 判断key是否存在
     * 
     * @param key
     * @return
     */
    public Boolean exists(final String key) {
        return this.execute(new Function<ShardedJedis, Boolean>() {
            @Override
            public Boolean callback(ShardedJedis e) {
                return e.exists(key);
            }
        });
    }

    /**
     * 根据map新建zset
     * 
     * @param key
     * @param map
     * @return
     */
    public Long creatZset(final String key, final Map<String, Double> map) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callback(ShardedJedis e) {
                return e.zadd(key, map);
            }
        });
    }

    public void testRedisHest() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("test","zhangnan");
        String test = jedis.get("test1");
        System.out.println(test);

        // 往rdis添加商品,如果第二次添加时第三个参数相同,则覆盖之前的
        // jedis.zadd("TAOTAO_APPLE",24.0,"我的最爱");
        //从大到小取出元素
        //Set<String> zrevrange = jedis.zrevrange("TAOTAO_APPLE", 1, 55);
        //从小到大取出元素
        /*Set<String> zrevrange1 = jedis.zrange("TAOTAO_APPLE", 0, 2);
        for (String string : zrevrange1) {
            System.out.println(string);
        }*/
        /*for (String string : zrevrange) {
            System.out.println(string);
        }*/
        //判断是否存在
        //Boolean exists = jedis.exists("TAOTAO_APPLE");
        //System.out.println(exists);
       /* Map<String, Double> temp=new HashMap<String,Double>();
        temp.put("三星", 2.0);*/
        //jedis.zadd("TAOTAO_SANGSVANG", temp);
        //返回集合中元素的个数
        //Long zcard = jedis.zcard("TAOTAO_APPLE");
        //删除指定的元素
        //jedis.zrem("TAOTAO_APPLE", "性能非常好");
        //给某个评价加上某个得分
        //Double zincrby = jedis.zincrby("TAOTAO_APPLE", 23.0, "完美");
        //System.out.println(zincrby);
        //System.out.println(zcard);
        jedis.close();
    }
    
    
    public void testRedisSst() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //给商品添加属性,set结构
        //jedis.sadd("APPLE", "非常好","ffff");
        jedis.sadd("APPLE", "非常好aa");
        //查看某个商品的所有属性
        Set<String> smembers = jedis.smembers("APPLE");
        System.out.println(smembers);
        jedis.close();
    }
    public void testRedisList() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //给一个key插入一个属性
        //Long lpush = jedis.lpush("MI", "手机");
        //当key存在时,才插入数据
        //jedis.lpushx("MI", "xiaojji");
        //System.out.println(lpush);
        /*List<String> lrange = jedis.lrange("MI", 0, 3);
        for (String string : lrange) {
            System.out.println(string);
        }*/
        //在指定位置插入一个数据,把之前的覆盖掉
        /*String lset = jedis.lset("MI", 2, "机2");
        System.out.println(lset);*/
        //查询指定角标的元素
        /*String lindex = jedis.lindex("MI", 1);
        System.out.println(lindex);*/
        //保留范围内的元素,别的都删掉
        /*String ltrim = jedis.ltrim("MI", 0, 1);
        System.out.println(ltrim);*/
        //jedis.linsert("MI", LIST_POSITION.AFTER, "机", "醒来的");
        //向尾部添加元素,可以用于消息队列
        //Long rpush = jedis.rpush("MaI", "haohao");
        //System.out.println(rpush);
        //取出最后一个元素,并且删除这个元素
       /* String rpop = jedis.rpop("MI");
        System.out.println(rpop);*/
        
        //消费消息,并且将这个消息备份到另个一个key中,如果消费成功,在手动删除
        //消息队列,存:rpush,放在最后....取,用rpoplpush,同时放在备份表,成功操作后取出备份表的数据lrem方法
       // String rpoplpush = jedis.rpoplpush("MaI", "aa");
        
        List<String> brpop = jedis.brpop("aa");
        for (String string : brpop) {
            System.out.println(string);
        }
        //System.out.println(rpoplpush);
        //int a=1/0;
        
       // Long rpop = jedis.lrem("aa", 1, rpoplpush);
       // System.out.println(rpop);
        jedis.close();
    }

}
