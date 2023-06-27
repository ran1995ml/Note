package com.ran.designpattern.proxy.dynamic;

/**
 * Main
 * 安全代理
 * PersonBean存储客户信息，通过代理限制对PersonBean的操作
 * @author rwei
 * @since 2023/6/26 14:41
 */
public class Main {
    public static void main(String[] args) {
        PersonBean personBean = getPersonBean();
        PersonProxy personProxy = new PersonProxy();

        PersonBean ownerProxy = personProxy.getOwnerProxy(personBean);
        System.out.println(ownerProxy.getGender());
        ownerProxy.setInterests("dnf");
        System.out.println(ownerProxy.getInterests());
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Error: owner cannot update rate");
        }

        PersonBean nonOwnerProxy = personProxy.getNonOwnerProxy(personBean);
        System.out.println(nonOwnerProxy.getGender());
        nonOwnerProxy.setHotOrNotRating(100);
        System.out.println(nonOwnerProxy.getHotOrNotRating());
        nonOwnerProxy.setHotOrNotRating(1);
        System.out.println(nonOwnerProxy.getHotOrNotRating());
        try {
            nonOwnerProxy.setInterests("qq");
        } catch (Exception e) {
            System.out.println("Error: cannot update ");
        }
    }

    public static PersonBean getPersonBean() {
        PersonBeanImpl personBean = new PersonBeanImpl();
        personBean.setName("Tom");
        personBean.setGender("M");
        personBean.setInterests("music");
        return personBean;
    }
}
