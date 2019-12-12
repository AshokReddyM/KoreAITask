package com.example.koreaitask.data.dummy;

public class DummyItem {

    private String id;
    private String title;
    private String subtitle;

    public DummyItem(String id, String title, String subtitle) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

}
