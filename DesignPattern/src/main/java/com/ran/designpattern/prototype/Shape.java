package com.ran.designpattern.prototype;

/**
 * Shape
 *
 * @author rwei
 * @since 2023/6/27 17:35
 */
public abstract class Shape implements Cloneable {
    private String id;

    protected String type;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public abstract void draw();
}
