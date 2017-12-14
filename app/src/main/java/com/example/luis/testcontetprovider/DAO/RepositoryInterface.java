package com.example.luis.testcontetprovider.DAO;

import android.database.Cursor;

import java.util.List;

/**
 * Created by luis on 13/12/17.
 */

public interface RepositoryInterface {

    List<Long> insert();

    Boolean update();

    Boolean remove();

    Cursor findAll();

    Cursor findByID(Long id);


}
