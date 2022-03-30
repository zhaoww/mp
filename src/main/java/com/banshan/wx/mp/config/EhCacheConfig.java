//package com.banshan.wx.mp.config;
//
//import net.sf.ehcache.CacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
///**
// * ehcache
// *
// * @author 半山兄
// * @since 2022/03/29
// */
//@Configuration
//public class EhCacheConfig {
//    @Bean(name = "ehCacheManager")
//    public CacheManager cacheManager() {
//        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        cacheManagerFactoryBean.setShared(true);
//        cacheManagerFactoryBean.afterPropertiesSet();
//        return cacheManagerFactoryBean.getObject();
//    }
//}
