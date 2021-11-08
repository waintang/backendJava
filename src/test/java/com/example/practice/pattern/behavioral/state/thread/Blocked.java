package com.example.practice.pattern.behavioral.state.thread;

public class Blocked extends ThreadState {
    public Blocked(){
        this.stateName = "已阻塞";
    }

    public void resume(ThreadContext threadContext){
        if(!stateName.equals("已阻塞")){
            System.out.println("非 已阻塞 不能恢复。" );
            return;
        }
        System.out.println("恢复线程。" );
        threadContext.setThreadState(new Runnable());
    }
}
