package com.ran.designpattern.prototype;

import java.util.HashMap;

/**
 * ShapeCache
 * 缓存获取到的类
 * @author rwei
 * @since 2023/6/27 17:44
 */
public class ShapeCache {
    private static HashMap<String, Shape> map = new HashMap<>();

    public static Shape getShape(String id) {
        Shape shape = map.get(id);
        return (Shape) shape.clone();
    }

    public static void loadCache() {
        Rectangle rectangle = new Rectangle();
        rectangle.setId("1");
        map.put("1", rectangle);
    }
}
