package com.example.koreaitask.data.dummy;

import java.util.ArrayList;
import java.util.List;


public class DummyContent {

    public static final List<DummyItem> items = new ArrayList<DummyItem>();

    private static int count = 20;


    public static List<DummyItem> generateItems() {
        count = items.size() + count;
        for (int i = 1; i <= count; i++) {
            addItem(createDummyItem(i));
        }

        return items;
    }

    private static void addItem(DummyItem item) {
        items.add(item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, "This is subtitle " + position);
    }

}
