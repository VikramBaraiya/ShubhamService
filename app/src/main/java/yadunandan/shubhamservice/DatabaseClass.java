package yadunandan.shubhamservice;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CustomerService.class},version = 1)
public abstract class DatabaseClass extends RoomDatabase {
    public abstract DatabaseAccessObject daobj();
    public static DatabaseClass INSTANCE;

}
