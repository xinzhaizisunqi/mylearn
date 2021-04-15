package com.example.demo.generic;

/**
 * @author 孙琦
 * @version 1.0
 * @description: TODO
 * @date 2020/12/31 17:15
 */
public interface AIConfig<T> {

    /**获取配置类
     * @param configValue
     * @return
     */
    public T getConfig(String configValue);

    /**获取配置类类型
     * @return
     */
    public AConfigTypeEnum getType();
}
