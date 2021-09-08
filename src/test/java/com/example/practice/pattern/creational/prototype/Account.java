package com.example.practice.pattern.creational.prototype;

import lombok.*;

/**
 * 类名 Account
 * 描述 账户类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account /*implements Cloneable*/ extends SerialClone{
    /** 主键 */
    private Long id;
    /** 账户名称 */
    private String name;
    /** 账户详情 */
    private AccountDetail detail;
    /** 重写clone方法，改为public方便外部调用 */
    /*@Override
    public Object clone() throws CloneNotSupportedException {
        // 第一个测试：只克隆了引用
        //return super.clone();
        // 第二个测试：类做属性时，类重写clone，层层递进、进行浅克隆
        Account account = (Account) super.clone();
        account.setDetail((AccountDetail) account.getDetail().clone());
        return account;
    }*/
}

