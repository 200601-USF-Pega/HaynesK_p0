package com.revature.neveragain.DAO;

import com.revature.neveragain.Models.Log;

import java.util.List;

public interface ILogRepo {
        public Log addLogs(Log log);
        public List<Log> getAllLogs();
}
