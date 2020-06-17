package com.revature.neveragain.DAO;

import com.revature.neveragain.Models.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogRepoFile implements ILogRepo {

    private String filepath = "src/com/revature/neveragain/Resources/LogFile.txt";

    @Override
    public Log addLogs(Log log) {
        List<Log> currentLog = this.getAllLogs();

        try {
            ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(filepath));
            currentLog.add(log);
            fileOut.writeObject(currentLog);
            fileOut.close();
            return log;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Log> getAllLogs() {
        try{
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(filepath));
            List<Log> retrievedLog = (ArrayList<Log>) fileIn.readObject();
            fileIn.close();
            return retrievedLog;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Log>();
    }
}
