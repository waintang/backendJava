package com.example.practice.pattern.behavioral.state.share;

import java.util.HashMap;

public class ShareContext {

    private ShareState shareState;
    private HashMap<String,ShareState> stateSet = new HashMap<String ,ShareState>();

    public ShareContext(){
        this.shareState = new ConcreteShare1();
        stateSet.put("1",shareState);// 此处 传值（值为对象引用的地址）【shareState 地址作为值 传给 stateSet对象的value值】
        this.shareState = new ConcreteShare2();
        stateSet.put("2",shareState);// 此处 也是传值（值为对象引用的地址），所以并不会 map的两个值 重复
        this.shareState = stateSet.get("1");
    }

    public ShareState getShareState(String key) {
        return stateSet.get(key);
    }

    public void setShareState(ShareState shareState) {
        this.shareState = shareState;
    }

    public void handle(){
        shareState.handle(this);
    }
}
