package com.around.springmvc.model.vo;

public class Sample {
    private String perfix;
    private String name;

    public Sample() {
    }

    @Override
    public String toString() {
        return "Sample{" +
                "perfix='" + perfix + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getPerfix() {
        return perfix;
    }

    public void setPerfix(String perfix) {
        this.perfix = perfix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
