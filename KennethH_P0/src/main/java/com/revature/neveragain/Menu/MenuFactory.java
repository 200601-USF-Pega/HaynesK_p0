package com.revature.neveragain.Menu;

public class MenuFactory {

    public com.revature.neveragain.Menu.IterMenu getMenu(String menumode) {
        IterMenu MenuNow;
        switch (menumode) {

            case "MainMenu":
                return new MainMenu();
            case "UserMenu":
                return new UserMenu();
            case "ManagerMenu":

        }
        return null;
    }
}
