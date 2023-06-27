package com.ran.designpattern.singleton.lazy;

/**
 * SingletonEnum
 * 枚举实现单例，除了保证线程安全，还能防止反序列化重新创建新的对象
 * 反射可能不能保证实例的唯一性，但枚举可以始终保证唯一性
 * @author rwei
 * @since 2023/6/16 10:56
 */
public enum SingletonEnum {
    //访问他等于获取了SingletonEnum的引用
    instance;

    private SingletonEnum() {}

    public void getinstance() {}

    public static void main(String[] args) {
        SingletonEnum.instance.getinstance();
    }
}
