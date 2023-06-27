package com.ran.designpattern.proxy.dynamic;

/**
 * PersonBean
 *
 * @author rwei
 * @since 2023/6/26 11:28
 */
public interface PersonBean {
    public String getName();

    public String getGender();

    public String getInterests();

    public int getHotOrNotRating();

    public void setName(String name);

    public void setGender(String gender);

    public void setInterests(String interests);

    public void setHotOrNotRating(int rating);
}
