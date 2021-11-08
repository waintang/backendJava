package com.example.practice.pattern.behavioral.state.thread;

public class ThreadContext {

    public ThreadContext(){
        this.threadState = new New();
    }

    private ThreadState threadState;

    public ThreadState getThreadState() {
        return threadState;
    }

    public void setThreadState(ThreadState threadState) {
        this.threadState = threadState;
    }

    public void start(){
        ((New)threadState).start(this);
    }

    public void getCPU(){
        ((Runnable)threadState).getCPU(this);
    }

    public void stop(){
        ((Running)threadState).stop(this);
    }

    public void suspend(){
        ((Running)threadState).suspend(this);
    }

    public void resume(){
        ((Blocked)threadState).resume(this);
    }

}
