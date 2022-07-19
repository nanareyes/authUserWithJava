package org.sofka.controller;

import org.sofka.view.menu;

public class MyApp {
    public void run() {
        menu view = new menu();
        do {
            view.showMenu();
//            view.createUser();
            view.captureOption();
            view.showMenuOptions();
//            view.menuForCreateUser();
        } while (view.getOption() != 4);
    }
}
