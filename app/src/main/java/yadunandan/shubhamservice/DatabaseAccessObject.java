package yadunandan.shubhamservice;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DatabaseAccessObject {
    @Insert
    public void insertServiceRequest(CustomerService cs);

    @Query("select * from CustomerService where Status ='Pending'")
    public List<CustomerService> viewService();

    @Update
    public void updateStatus(CustomerService cs);

    @Query("select * from CustomerService where Status !='Pending'")
    public List<CustomerService> viewCompleted();

}
