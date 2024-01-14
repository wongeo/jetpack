package com.feng.jetpack.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//提供增删改查
@Dao
public interface PersonDao {

    @Insert
    void insertPerson(Person... people);

    @Delete
    void deletePerson(Person... people);

    @Update
    void updatePerson(Person... people);

    @Query("select * from person")
    List<Person> getAllPerson();

    @Query("select * from person where id =:id")
    List<Person> getPersonById(int id);

    @Query("delete from person")
    void deleteAll();
}
