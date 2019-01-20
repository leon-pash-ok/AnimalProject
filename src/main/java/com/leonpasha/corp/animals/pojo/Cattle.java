package com.leonpasha.corp.animals.pojo;

import java.util.Date;

public abstract class Cattle implements AnimalRecord {
    protected String typeName;
    protected int count;
    protected Date date;

    @Override
    public String getTypeName() {
        return typeName;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String returnStringAfterAdd(){
        return "";
    }


}
