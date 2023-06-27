package com.ran.designpattern.proxy.dynamic;

/**
 * PersonBeanImpl
 * 该对象可随意修改成员变量值
 * @author rwei
 * @since 2023/6/26 13:34
 */
public class PersonBeanImpl implements PersonBean {
    private String name;

    private String gender;

    private String interests;

    private int rating;

    private int ratingCount;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) return 0;
        return (rating / ratingCount);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }
}
