package com.revature.neveragain.Menu;

import com.revature.neveragain.DAO.LogDAO;
import com.revature.neveragain.DAO.LogDaoImp;
import com.revature.neveragain.Models.Log;

import java.util.Scanner;

public class UserMenu implements IterMenu {
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

        System.out.println("This is the User Menu. Please Enter an option below");

        do {
            System.out.println("Press 1:  Get a list of all the Logs");
            System.out.println("Press 2:  Add a Log");
            System.out.println("Press 3:  Delete a Log");
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
                    System.out.println("What would you rank this restaurant? 5 meaning you will never go thier again.");
                    rank = scan.nextInt();

                    System.out.println("what is the name of the Restaurant? ");
                    Rname = scan.next();

                    System.out.println("what type of food do they serve?");
                    Rcategory = scan.next();

                    System.out.println("what is the resutaurants address?");
                    Raddress = scan.next();

                    System.out.println("In which city was this restaurant located?");
                    Rcity = scan.next();

                    System.out.println("Please share your experience that you had with this restaurant");
                    usercomment = scan.next();

                    System.out.println("Thank you for your log!");


                    Log newlog = new Log(Rname,Rcategory,Raddress,Rcity,rank,usercomment);

                    logDAO.addLogs(newlog);
                    System.out.println("Log Added");

                    break;

                case 3:
                    logDAO.getAllLogs();
                    System.out.println("Enter the file you want to delete");
                    int userinput = scan.nextInt();

                    logDAO.deleteLogs(userinput);
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
