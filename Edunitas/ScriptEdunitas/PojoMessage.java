package com.mgi.edunitas;

/**
 * Created by acer on 1/20/2017.
 */

public class PojoMessage {
    private String message, createdBy;
    long createdOn;
    public PojoMessage(){}
    public PojoMessage(String message, long createdOn, String createdBy){
        this.message = message;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
