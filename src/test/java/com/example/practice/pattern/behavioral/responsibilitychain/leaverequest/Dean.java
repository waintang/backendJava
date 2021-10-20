package com.example.practice.pattern.behavioral.responsibilitychain.leaverequest;

public class Dean extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if(leaveDays <= 10 ){
            System.out.println("院长批准。");
        }else{
            if(getNextLeader() != null){
                System.out.println("院长备注，请上级再行审批。");
                getNextLeader().handleRequest(leaveDays);
            }else{
                System.out.println("请假太多，无人审批。");
            }
        }
    }
}
