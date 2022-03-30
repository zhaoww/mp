//package com.banshan.wx.mp.service.util;
//
//import net.sf.ehcache.Cache;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//
///**
// * @author 半山兄
// * @since 2022/03/29
// */
//@SpringBootTest
//public class EhcacheTest {
//
//    @Resource
//    private CacheManager manager;
//    /**
//     * 通过缓存管理器获取Cache
//     */
//    private Cache myCache;
//
//    @BeforeEach
//    public void before() {
//        // 获取缓存管理器
////        manager = CacheManager.newInstance("src/main/resources/ehcache.xml");
//        // 通过缓存管理器获取Cache
//        myCache = manager.getCache("myCache");
//    }
//
//    @Test
//    public void testAdd() {
//        // 构造缓存元素, key: id, value: 对象
//        Element element1 = new Element("key1", "value1");
//        Element element2 = new Element("key2", "value2");
//        // 放入缓存
//        myCache.put(element1);
//        myCache.put(element2);
//
//        testGet();
//    }
//
//    @Test
//    public void testGet() {
//        // 根据key从Cache获取相应的Element
//        Element element = myCache.get("key2");
//        // Element的value即为所需的缓存数据
//        String value = (String) element.getObjectValue();
//        System.out.println("value:" + value);
//    }
//}
