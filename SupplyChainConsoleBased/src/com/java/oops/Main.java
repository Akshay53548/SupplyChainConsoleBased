package com.java.oops;

import java.util.Arrays;
import java.util.List;

interface Database{
     String findById(int id);
     List<String> findAll();
}


class HeavyWeightDatabase implements Database{

    @Override
    public String findById(int id) {
        return "HeavyWeightDatabase : returning data with id" +id;
    }

    @Override
    public List<String> findAll() {
        return Arrays.asList("HWD1", "HWD2", "HWD3");
    }
}


class LightWeightDatabase implements Database{

    @Override
    public String findById(int id) {
        return "LightWeightDatabase: returning data with id" +id;
    }

    @Override
    public List<String> findAll() {
        return Arrays.asList("LWD1", "LWD2", "LWD3");
    }
}



class DatabaseFactory{
    public Database createDatabaseImpl(String profile){
        if(profile.equals("prod")){
            return new HeavyWeightDatabase();
        }else{
            return new LightWeightDatabase();
        }
    }
}


class DatabaseService{
    Database database = null;

    public DatabaseService(Database database) {
        this.database = database;
    }

    public List<String> getAllData(){
        return database.findAll();
    }

    public String getData(int id){
        return database.findById(id);
    }
}
public class Main {
    public static void main(String[] args) {
        DatabaseFactory databaseFactory = new DatabaseFactory();

       String profile ="prod";
       // String profile ="dev";
        Database database = new DatabaseFactory().createDatabaseImpl(profile);
        DatabaseService databaseService =new DatabaseService(database);
        System.out.println(databaseService.getData(123));
        System.out.println(databaseService.getAllData());

    }
}
