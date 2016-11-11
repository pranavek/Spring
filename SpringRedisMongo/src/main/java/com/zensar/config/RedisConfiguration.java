package com.zensar.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("127.0.0.1");
		jedisConnectionFactory.setPort(6379);
		return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setExposeConnection(true);
		redisTemplate.setKeySerializer(stringRedisSerializer()); // For String
		//redisTemplate.setValueSerializer(jackson2JsonRedisJsonSerializer());															// keys, not
		redisTemplate.setValueSerializer(genericJackson2JsonRedisJsonSerializer());														// wired
																	// keys like
																	// whitePaper:\xac\xed\x00\x05t\x00\x05title
		return redisTemplate;
	}

	@Bean
	public StringRedisSerializer stringRedisSerializer() {
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		return stringRedisSerializer;
	}

	@Bean
	public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisJsonSerializer() {
		GenericJackson2JsonRedisSerializer genericJackson2JsonRedisJsonSerializer = new GenericJackson2JsonRedisSerializer();
		return genericJackson2JsonRedisJsonSerializer;
	}

	@Bean
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
		redisCacheManager.setTransactionAware(true);
		redisCacheManager.setLoadRemoteCachesOnStartup(true);
		redisCacheManager.setUsePrefix(true);
		return redisCacheManager;
	}
	
	/*static class JsonRedisSerializer implements RedisSerializer<Object> {

		private final ObjectMapper om;

		public JsonRedisSerializer() {
			this.om = new ObjectMapper().enableDefaultTyping(DefaultTyping.NON_FINAL, As.PROPERTY);
		}

		@Override
		public byte[] serialize(Object t) throws SerializationException {
			try {
				return om.writeValueAsBytes(t);
			} catch (JsonProcessingException e) {
				throw new SerializationException(e.getMessage(), e);
			}
		}

		@Override
		public Object deserialize(byte[] bytes) throws SerializationException {
			
			if(bytes == null){
				return null;
			}
			
			try {
				return om.readValue(bytes, Object.class);
			} catch (Exception e) {
				throw new SerializationException(e.getMessage(), e);
			}
		}
	}*/


}
