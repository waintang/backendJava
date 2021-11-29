package com.example.practice.pattern.behavioral.memento.girl;

// 发起人
public class You {
    private String wifeName;

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    public Girl createMemento(){
        return new Girl(this.wifeName);
    }

    public void restoreMemento(Girl girl){
        this.setWifeName(girl.getName());
    }
}
