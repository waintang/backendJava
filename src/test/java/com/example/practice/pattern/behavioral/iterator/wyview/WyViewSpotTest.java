package com.example.practice.pattern.behavioral.iterator.wyview;

public class WyViewSpotTest {
    //  集合 聚合动作、迭代遍历动作  拆分开
    public static void main(String[] args) {
        // 抽象聚合 = 具体聚合
        ViewSpotSet viewSpotSet = new WyViewSpotSet();
        viewSpotSet.add(WyViewSpot.builder().name("景点A").introduce("A发源于XX，历经A时期").build());
        viewSpotSet.add(WyViewSpot.builder().name("景点B").introduce("B发源于XX，历经B时期").build());
        viewSpotSet.add(WyViewSpot.builder().name("景点C").introduce("C发源于XX，历经C时期").build());
        // 抽象迭代 = 具体迭代
        ViewSpotIterator viewSpotIterator = viewSpotSet.getIterator();
        while (viewSpotIterator.hasNext()){
            WyViewSpot wyViewSpot = viewSpotIterator.next();
            System.out.println(wyViewSpot.getName()+" "+wyViewSpot.getIntroduce());
        }
    }
}
