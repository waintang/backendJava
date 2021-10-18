package com.example.practice.pattern.behavioral.command.breakfast.invoker;

import com.example.practice.pattern.behavioral.command.breakfast.command.ChangFen;
import com.example.practice.pattern.behavioral.command.breakfast.command.HeFen;
import com.example.practice.pattern.behavioral.command.breakfast.command.HunTun;

public class Waiter {
    private ChangFen changFen;
    private HunTun hunTun;
    private HeFen heFen;

    // 服务员 初始化/拿到 菜单
    public Waiter(){
        changFen = new ChangFen();
        hunTun = new HunTun();
        heFen = new HeFen();
    }

    // 服务员 功能：下单，让命令/早餐 制作起来
    public void chooseChangFen(){
        changFen.cooking();
    }

    public void chooseHunTun(){
        hunTun.cooking();
    }

    public void chooseHeFen(){
        heFen.cooking();
    }

}

