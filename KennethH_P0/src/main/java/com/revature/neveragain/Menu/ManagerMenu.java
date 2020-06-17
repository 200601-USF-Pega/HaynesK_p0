package com.revature.neveragain.Menu;

import com.revature.neveragain.DAO.LogDAO;
import com.revature.neveragain.DAO.LogDaoImp;
import com.revature.neveragain.Models.Log;

import java.util.Scanner;

public class ManagerMenu implements IterMenu {

    @Override
    public void startmenu() {
        MenuFactory menuFactory = new MenuFactory();
        IterMenu newMenu;
        Scanner scan = new Scanner(System.in);

        LogDAO logDAO = null;

        try {
            logDAO = new LogDaoImp();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("This is the Manager Menu. Please Enter an option below");

        do {
            System.out.println("Press 1:  Get a list of all the Logs");
            System.out.println("Press 2:  Delete a User Account");
            System.out.println("Press 0:  To go back to Main Menu");

            String Rname;
            String Rcategory;
            String Raddress;
            String Rcity;
            int rank;
            String usercomment;

            int input = scan.nextInt();

            switch (input) {

                case 1:
                    logDAO.getAllLogs();
                    break;

                case 2:

                    break;

                case 0:
                    newMenu = menuFactory.getMenu("MainMenu");
                    newMenu.startmenu();
                    break;

                default:
                    System.out.println("Please Enter one of the options");
                    continue;

            }
        } while (true);

    }
}
