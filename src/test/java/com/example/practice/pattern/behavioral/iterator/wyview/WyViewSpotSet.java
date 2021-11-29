package com.example.practice.pattern.behavioral.iterator.wyview;

import java.util.ArrayList;
import java.util.List;

public class WyViewSpotSet implements ViewSpotSet{
    private List<WyViewSpot> wyViewSpotList = new ArrayList<WyViewSpot>();
    @Override
    public void add(WyViewSpot wyViewSpot) {
        wyViewSpotList.add(wyViewSpot);
    }

    @Override
    public void remove(WyViewSpot wyViewSpot) {
        wyViewSpotList.remove(wyViewSpot);
    }

    @Override
    public ViewSpotIterator getIterator() {
        return new WyViewSpotIterator(wyViewSpotList);
    }
}
