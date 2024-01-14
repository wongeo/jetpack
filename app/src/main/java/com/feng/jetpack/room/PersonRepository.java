package com.feng.jetpack.room;

import android.content.Context;

import java.util.List;

public class PersonRepository {

    private final PersonDao mPersonDao;

    public PersonRepository(Context context) {
        mPersonDao = PersonStoreDatabase.getInstance(context).getPersonDao();
    }

    public void insert(Person... people) {
        mPersonDao.insertPerson(people);
    }

    public List<Person> getAllPerson() {
        return mPersonDao.getAllPerson();
    }

    public void clear() {
        mPersonDao.deleteAll();
    }
}
