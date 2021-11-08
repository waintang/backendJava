package com.example.practice.pattern.behavioral.state.thread;

public class Running extends ThreadState {
    public Running(){
        this.stateName = "运行中";
    }

    public void stop(ThreadContext threadContext){
        if(!stateName.equals("运行中")){
            System.out.println("非 运行中 不能停止。" );
            return;
        }
        System.out.println("停止线程。" );
        threadContext.setThreadState(new Stopped());
    }

    public void suspend(ThreadContext threadContext){
        if(!stateName.equals("运行中")){
            System.out.println("非 运行中 不能阻塞。" );
            return;
        }
        System.out.println("阻塞线程。" );
        threadContext.setThreadState(new Blocked());
    }

}
