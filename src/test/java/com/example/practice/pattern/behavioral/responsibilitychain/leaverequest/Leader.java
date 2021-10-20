package com.example.practice.pattern.behavioral.responsibilitychain.leaverequest;

public abstract class Leader  {
    private Leader nextLeader;

    public Leader getNextLeader() {
        return nextLeader;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public abstract void handleRequest(int leaveDays);
}
