package controller;

public class item {
    private String name;
    private String type;
    private int value;

    public item(String name, String type, int value){
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }
    
}
