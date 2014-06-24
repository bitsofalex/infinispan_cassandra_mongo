package com.bits.r8d.content;

import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.loaders.jdbc.configuration.JdbcStringBasedCacheStoreConfigurationBuilder;
import org.infinispan.loaders.mongodb.configuration.MongoDBCacheStoreConfiguration;
import org.infinispan.loaders.mongodb.configuration.MongoDBCacheStoreConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexl on 23/06/2014.
 */
@Configuration
public class InfinispanCacheConfig {

    @Bean
    public ConfigurationBuilder getConfigurationBuilder() {
        // Mongo cache store
//        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
//        configurationBuilder.loaders().addStore(MongoDBCacheStoreConfigurationBuilder.class)
//                .host("localhost")
//                .port(27017)
//                .timeout(1500)
//                .acknowledgment(0)
//                .username("infinispan")
//                .password("infinispan")
//                .database( "infinispan_cachestore" )
//                .collection( "indexes" );

        // file cache store
//        ConfigurationBuilder builder = new ConfigurationBuilder();
//        builder.loaders()
//                .passivation(false)
//                .shared(false)
//                .preload(true)
//                .addFileCacheStore()
//                .fetchPersistentState(true)
//                .purgerThreads(3)
//                .purgeSynchronously(true)
//                .ignoreModifications(false)
//                .purgeOnStartup(false)
//                .location("/Users/alexl/Development/dbs")
//                .async()
//                .enabled(false)
//                .flushLockTimeout(15000)
//                .threadPoolSize(5)
//                .singletonStore()
//                .enabled(true)
//                .pushStateWhenCoordinator(true)
//                .pushStateTimeout(20000);

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.loaders().preload(true).addLoader(JdbcStringBasedCacheStoreConfigurationBuilder.class)
                .fetchPersistentState(true)
                .ignoreModifications(false)
                .purgeOnStartup(false)
                .table()
                .dropOnExit(false)
                .createOnStart(false)
                .tableNamePrefix("ISPN_STRING_TABLE")
                .idColumnName("ID_COLUMN").idColumnType("VARCHAR(255)")
                .dataColumnName("DATA_COLUMN").dataColumnType("BINARY")
                .timestampColumnName("TIMESTAMP_COLUMN").timestampColumnType("BIGINT")
                .connectionPool()
                .connectionUrl("jdbc:h2:tcp://localhost/~/infinispan_binary_based;DB_CLOSE_DELAY=-1")
                .username("sa")
                .driverClass("org.h2.Driver");
        return builder;
    }

    @Bean
    @Autowired
    public org.infinispan.configuration.cache.Configuration getConfiguration(final ConfigurationBuilder configurationBuilder) {
        return configurationBuilder.build();
    }

//    @Bean
//    @Autowired
//    public MongoDBCacheStoreConfiguration getMongoDBCacheStoreConfiguration(final org.infinispan.configuration.cache.Configuration configuration) {
//        return (MongoDBCacheStoreConfiguration)configuration.loaders().cacheLoaders().get(0);
//    }

    @Bean
    @Autowired
    public EmbeddedCacheManager getCacheManager(final org.infinispan.configuration.cache.Configuration configuration) {
        // MongoDBCacheStoreConfiguration store = (MongoDBCacheStoreConfiguration)configuration.loaders().cacheLoaders().get(0);
        EmbeddedCacheManager embeddedCacheManager = new DefaultCacheManager(configuration);
        // embeddedCacheManager.defineConfiguration("products", configuration);
        // embeddedCacheManager.getCache("products", true);

        return embeddedCacheManager;
    }
}
