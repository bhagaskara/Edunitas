package com.mgi.edunitas;

/**
 * Created by acer on 1/18/2017.
 */

public class PojoUser {
    private String nama, email;
    public PojoUser(){}
    public PojoUser(String nama, String email){
        this.nama = nama;
        this.email = email;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
