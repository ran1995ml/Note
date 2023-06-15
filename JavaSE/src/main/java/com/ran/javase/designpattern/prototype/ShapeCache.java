package com.ran.javase.designpattern.prototype;

import com.ran.javase.designpattern.prototype.shapeimpl.Circle;
import com.ran.javase.designpattern.prototype.shapeimpl.Rectangle;

import java.util.Hashtable;

/**
 * ShapeCache
 * 缓存对Shape的创建
 * @author rwei
 * @since 2023/3/26 21:57
 */
public class ShapeCache {
    private static Hashtable<String, Shape> map = new Hashtable<String, Shape>();

    public static Shape getShape(String id) {
        Shape shape = map.get(id);
        return (Shape) shape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        map.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        map.put(rectangle.getId(), rectangle);
    }
}
