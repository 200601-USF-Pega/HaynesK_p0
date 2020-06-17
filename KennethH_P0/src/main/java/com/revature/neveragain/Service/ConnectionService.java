package com.revature.neveragain.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    private static ConnectionService connectionService_instance = null;
    private Connection connection;

    public ConnectionService(){
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://ruby.db.elephantsql.com:5432/fmwedyid","fmwedyid","NUp4TP5r8Z0IgJeK21JrabFz6S4CxkCR");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){ return connection;}
    public static ConnectionService getInstance(){
        if( connectionService_instance == null){
            connectionService_instance = new ConnectionService();
        }
    return connectionService_instance;
    }
}
