package yadunandan.shubhamservice;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface DatabaseAccessObject {
    @Insert
    public void insertServiceRequest(CustomerService cs);

}
