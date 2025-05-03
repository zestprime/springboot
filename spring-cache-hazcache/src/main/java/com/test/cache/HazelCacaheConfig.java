package com.test.cache;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelCacaheConfig {

	 	@Bean
	    public Config hazelCastConfig() {
	        return new Config()
	                .setInstanceName("hazelcast-instance")
	                .addMapConfig(new MapConfig()
	                        .setName("myCache")
	                        .setTimeToLiveSeconds(300)); // Cache TTL of 5 minutes
	    }

	    @Bean
	    public HazelcastInstance hazelcastInstance(Config config) {
	        return Hazelcast.newHazelcastInstance(config);
	    }
}
