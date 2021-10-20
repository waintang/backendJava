package com.example.practice.pattern.behavioral.responsibilitychain.leaverequest;

public class DepartmentHead extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if(leaveDays <= 5 ){
            System.out.println("系主任批准。");
        }else{
            if(getNextLeader() != null){
                System.out.println("系主任备注，请上级再行审批。");
                getNextLeader().handleRequest(leaveDays);
            }else{
                System.out.println("请假太多，无人审批。");
            }
        }
    }
}
