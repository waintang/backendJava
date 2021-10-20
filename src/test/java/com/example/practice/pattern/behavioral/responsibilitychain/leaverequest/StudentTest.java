package com.example.practice.pattern.behavioral.responsibilitychain.leaverequest;

public class StudentTest {
    private static Leader classAdviser = new ClassAdviser();
    private static Leader departmentHead = new DepartmentHead();
    private static Leader dean = new Dean();

    public static void main(String[] args) {
        classAdviser.setNextLeader(departmentHead);
        departmentHead.setNextLeader(dean);
        requestLeave(17);
    }

    public static void requestLeave(int leaveDays){
        classAdviser.handleRequest(leaveDays);
    }
}
