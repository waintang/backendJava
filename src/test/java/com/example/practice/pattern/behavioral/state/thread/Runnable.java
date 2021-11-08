package com.example.practice.pattern.behavioral.state.thread;

public class Runnable extends ThreadState {
    public Runnable(){
        this.stateName = "就绪状态";
    }

    public void getCPU(ThreadContext context){
        if(!stateName.equals("就绪状态")){
            System.out.println("非 就绪状态 不能运行。" );
            return;
        }
        System.out.println("启动线程。" );
        context.setThreadState(new Running());
    }

}
