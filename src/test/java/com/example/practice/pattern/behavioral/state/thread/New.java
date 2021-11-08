package com.example.practice.pattern.behavioral.state.thread;

public class New extends ThreadState {
    public New(){
        this.stateName = "新建状态";
    }

    public void start(ThreadContext context){
        if(!stateName.equals("新建状态")){
            System.out.println("非 新建状态 不能启动。" );
            return;
        }
        System.out.println("准备线程。" );
        context.setThreadState(new Runnable());
    }
}
