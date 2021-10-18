package com.example.practice.pattern.behavioral.command.breakfast;

import com.example.practice.pattern.behavioral.command.breakfast.command.Breakfast;
import com.example.practice.pattern.behavioral.command.breakfast.command.ChangFen;
import com.example.practice.pattern.behavioral.command.breakfast.command.HeFen;
import com.example.practice.pattern.behavioral.command.breakfast.invoker.Waiter;
import com.example.practice.pattern.behavioral.command.breakfast.invoker.Waiter2;

// 模拟 顾客下单过程
public class BreakFastTest {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.chooseChangFen();

        Breakfast changfen = new ChangFen();
        Breakfast hefen = new HeFen();
        Waiter2 waiter2 = new Waiter2();
        waiter2.addBreakfast(changfen);
        waiter2.addBreakfast(hefen);
        waiter2.confirmAndOrder();

    }
}
