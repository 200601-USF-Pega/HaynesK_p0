package com.revature.neveragain.Driver;

import com.revature.neveragain.Menu.MainMenu;
import com.revature.neveragain.Service.ConnectionService;

public class Driver {


    public static void main(String[] args) {
        ConnectionService connectionService = ConnectionService.getInstance();

        MainMenu mainMenu = new MainMenu();
        mainMenu.startmenu();
    }
}
