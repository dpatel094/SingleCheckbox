package com.dijolapp.my;

// Item.java
public class Item {
    private int id;
    private String name;
    private boolean isChecked;

    public Item(int id, String name,Boolean check) {
        this.id = id;
        this.name = name;
        this.isChecked = check;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
