package com.filling_station.Allocation.SpringBoot;

public class Order {
    private long id;
    private String content;

    public Order(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public void Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
