package com.example.practice.pattern.create.prototype;

import java.io.Serializable;

/**
 * 类名 SerialClone
 * 描述 序列化克隆类，只有继承该类，就可以实现深克隆
 *
 */
public class SerialClone implements Cloneable, Serializable {
    private static final long serialVersionUID = 5794148504376232369L;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return SerialCloneUtils.deepClone(this);
    }
}
