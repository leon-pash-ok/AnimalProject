package com.leonpasha.corp.animals.pojo;

import java.util.Date;

public interface AnimalRecord {
    String getTypeName();
    int getCount();
    void setCount(int count);
    Date getDate();
    void setDate(Date date);
    String returnStringAfterAdd();

    default String print(){
        return String.format("Animal type: %s, count: %d, date: %tF", getTypeName(), getCount(), getDate());
    }
}
