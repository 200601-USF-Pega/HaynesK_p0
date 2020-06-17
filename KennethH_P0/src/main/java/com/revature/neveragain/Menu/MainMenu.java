package com.revature.neveragain.Menu;

import java.util.Scanner;

public class MainMenu implements IterMenu {

    //We are overriding the IMenu's method tag
    @Override
    public void startmenu() {
        MenuFactory menuFactory = new MenuFactory();
        IterMenu newMenu;

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome! Please Enter an option below");

        while (true) {

            System.out.println("Press 1: User Menu");
            System.out.println("Press 2: Manager Menu");
            System.out.println("Press 0: To exit the program");

            int nextMenu = scan.nextInt();

            switch (nextMenu) {

                case 1:
                    newMenu = menuFactory.getMenu("UserMenu");
                    newMenu.startmenu();
                    break;

                case 2:
                 /*   newMenu = menuFactory.getMenu("ManagerMenu");
                    newMenu.startmenu();
                    break;*/
                    newMenu = menuFactory.getMenu("MainMenu");
                    newMenu.startmenu();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please Enter one of the options");
                    continue;

            }
        }

    }
}