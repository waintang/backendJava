package com.example.practice.pattern.creational.prototype.shallowcopy;

public abstract class Shape implements Cloneable {

    private Long id;
    protected String type;

    abstract void draw();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
