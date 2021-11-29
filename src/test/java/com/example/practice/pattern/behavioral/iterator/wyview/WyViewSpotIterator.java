package com.example.practice.pattern.behavioral.iterator.wyview;

import java.util.List;

public class WyViewSpotIterator implements ViewSpotIterator{
    private List<WyViewSpot> wyViewSpotList = null;
    private int index = -1;

    public WyViewSpotIterator(List<WyViewSpot> wyViewSpotList){
        this.wyViewSpotList = wyViewSpotList;
    }

    @Override
    public WyViewSpot first() {
        index = 0;
        return wyViewSpotList.get(index);
    }

    @Override
    public WyViewSpot next() {
        WyViewSpot wyViewSpot = null;
        if(hasNext()){
            wyViewSpot = wyViewSpotList.get(++index);
        }
        return wyViewSpot;
    }

    @Override
    public boolean hasNext() {
        if(index < wyViewSpotList.size()-1){
            return true;
        }
        return false;
    }
}
