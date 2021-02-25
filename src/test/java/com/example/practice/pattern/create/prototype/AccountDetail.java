package com.example.practice.pattern.create.prototype;

import lombok.*;

/**
 * 类名 AccountDetail
 * 描述 账户详情类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetail /*implements Cloneable*/ extends SerialClone {
    /** 账户ID */
    private Long accountId;
    /** 邮箱 */
    private String email;
/*
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/
}