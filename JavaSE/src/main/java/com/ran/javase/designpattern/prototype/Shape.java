package com.ran.javase.designpattern.prototype;

/**
 * Shape
 *
 * @author rwei
 * @since 2023/3/26 21:20
 */
public abstract class Shape implements Cloneable {
    private String id;

    protected String type;

    public abstract void draw();

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return object;
    }
}
