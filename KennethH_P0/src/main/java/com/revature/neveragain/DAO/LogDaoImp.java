package com.revature.neveragain.DAO;

import com.revature.neveragain.Models.Log;
import com.revature.neveragain.Service.ConnectionService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogDaoImp implements LogDAO {

    ConnectionService connectionService = ConnectionService.getInstance();


    @Override
    public List<Log> getAllLogs() {
        List<Log> currentLog = new ArrayList<Log>();
        int Indexcount = 1;

        try {
            PreparedStatement preparedStatement = connectionService.getConnection().prepareStatement("SELECT * FROM logs;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Log log = new Log(resultSet.getString("restaurant_name"), resultSet.getString("category"), resultSet.getString("address"), resultSet.getString("city"),
                        resultSet.getInt("ranking"), resultSet.getString("log_comments"));
                currentLog.add(log);
            }
            for (Log log : currentLog) {
                System.out.println(" " + Indexcount + ": " + currentLog.toString());
                Indexcount++;
            }

            return currentLog;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Log> getAllLogsnp() {
        List<Log> currentLog = new ArrayList<Log>();
        int Indexcount = 1;

        try {
            PreparedStatement preparedStatement = connectionService.getConnection().prepareStatement("SELECT * FROM logs;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Log log = new Log(resultSet.getString("restaurant_name"), resultSet.getString("category"), resultSet.getString("address"), resultSet.getString("city"),
                        resultSet.getInt("ranking"), resultSet.getString("log_comments"));
                currentLog.add(log);
            }
            return currentLog;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addLogs(Log log) {

        try {
            List<Log> currentLog = this.getAllLogsnp();
            currentLog.add(log);
            try {
                PreparedStatement preparedStatement = connectionService.getConnection().prepareStatement("INSERT INTO logs (restaurant_name, category, address, city, ranking, log_comments) VALUES (?,?,?,?,?,?);");
                preparedStatement.setString(1,log.getRestaurantName());
                preparedStatement.setString(2,log.getCategory());
                preparedStatement.setString(3,log.getAddress());
                preparedStatement.setString(4,log.getCity());
                preparedStatement.setInt(   5,log.getRank());
                preparedStatement.setString(6,log.getComment());
                preparedStatement.execute();
                boolean worked = preparedStatement.execute();

                return worked;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return true;

        }catch (Exception e ) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("error adding log");
            return false;
        }
    }

    @Override
    public boolean deleteLogs(int userinput) {
        try{
            List<Log> currentLog = this.getAllLogsnp();
            Log log = currentLog.get(userinput -1);

            PreparedStatement preparedStatement = connectionService.getConnection().prepareStatement("DELETE FROM logs as d WHERE d.restaurant_name = ? AND d.category = ? AND d.address = ? AND d.city = ? AND d.ranking = ? AND d.log_comments = ?;");
            preparedStatement.setString(1,log.getRestaurantName());
            preparedStatement.setString(2,log.getCategory());
            preparedStatement.setString(3,log.getAddress());
            preparedStatement.setString(4,log.getCity());
            preparedStatement.setInt(   5,log.getRank());
            preparedStatement.setString(6,log.getComment());
            preparedStatement.execute();
            boolean worked = preparedStatement.execute();
            System.out.println("We deleted: " + currentLog.toString());
            return  worked;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Deleted a log");

        }

        return false;
    }
}
