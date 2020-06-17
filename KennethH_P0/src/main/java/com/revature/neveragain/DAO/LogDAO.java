package com.revature.neveragain.DAO;

import com.revature.neveragain.Models.Log;

import java.util.List;

public interface LogDAO {
    public List<Log> getAllLogs();
    public List<Log> getAllLogsnp();
    public boolean addLogs(Log log);
    public boolean deleteLogs(int userinput);
}
