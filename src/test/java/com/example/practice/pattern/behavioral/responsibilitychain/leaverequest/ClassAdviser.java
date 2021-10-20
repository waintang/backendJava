package com.example.practice.pattern.behavioral.responsibilitychain.leaverequest;

public class ClassAdviser extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if(leaveDays <= 2 ){
            System.out.println("班主任批准。");
        }else{
            if(getNextLeader() != null){
                System.out.println("班主任备注，请上级再行审批。");
                getNextLeader().handleRequest(leaveDays);
            }else{
                System.out.println("请假太多，无人审批。");
            }
        }
    }
}
