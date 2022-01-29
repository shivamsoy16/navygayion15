package com.su.periodictable;

class Model {

    String no;
    String symbol;
    String name;

    //constructor

    public Model(String no, String symbol, String name) {
        this.no = no;
        this.symbol = symbol;
        this.name = name;
    }

    //getter

    public String getNo() {
        return this.no;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }
}
