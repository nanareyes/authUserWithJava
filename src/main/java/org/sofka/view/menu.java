package org.sofka.view;

import org.jboss.logging.Logger;
import org.sofka.model.User;
import org.sofka.model.UserConnectionDB;
import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class menu {
    private static final Logger logger = Logger.getLogger(menu.class);
    private Integer option;
    Scanner sc = new Scanner(System.in);
    private User myUser = new User();

    public Integer getOption() {
        return option;
    }

    public void showMenu() {
        logger.info("\n1. Crear un usuario\n2. Loguear un usuario\n3. Salir");
    }

    public String userPassword() {
        Console console = System.console();
        if (console == null) {
            logger.info("Couldn't get Console instance");
            System.exit(0);
        }

        char[] passwordArray = console.readPassword("Enter your secret password: ");
        if(!this.validateEmail(new String(passwordArray))){
            logger.info("La contraseña debe tener entre 5 y 16 caracteres alfanuméricos");
            return  this.userPassword();
        }
        char[] secondPasswordArray = console.readPassword("Enter your secret password again: ");

        if((new String(passwordArray)).equals(new String(secondPasswordArray))) {
            logger.info("ingreso la contraseña de forma correcta");
            return String.valueOf(passwordArray);
        }else {
            logger.error("error! debe coincidir las contraseñas");
            return this.userPassword();
        }
    }

    public boolean validateEmail(String password){
        Pattern pattern = Pattern.compile("^\\w{5,16}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public void createUser(){
        logger.info("Digite su nombre");
        String name = sc.nextLine();
        logger.info("Digite su apellido");
        String lastName = sc.nextLine();
        logger.info("Digite su email");
        String email = sc.next();
        logger.info("Digite su password");

        String password = this.userPassword();
        if(password != null){
            myUser = new User(name, lastName, email, password);
            UserConnectionDB.addUser(myUser);
        }

        logger.info("Los datos ingresados son: \nNombre: " + myUser.getName()+" "+ myUser.getLastName() +"\nY el email es: " + myUser.getEmail() + "\nY el password es: "+myUser.getPassword());
    }

    public void logUser(){
        logger.info("\n1. Digite su email\n2. Digite su contraseña\n3. Salir");
    }


    public void insertName() {
        logger.info("\nDigite su nombre: ");
    }

    public void insertLastname() {
        logger.info("\nDigite su apellido: ");
    }
    public void insertEmail() {
        logger.info("\nDigite su email: ");
    }

    public void insertPassword() {
        logger.info("\nDigite su email: ");
    }

    public void showFullName(String nombre, String apellido) {
        logger.info("\n" + nombre + " " + apellido);
    }


    public void showMenuOptions() {
        switch (option) {
            case 1:
                createUser();
                //myUser.setName(myScanner.getInstance().getString());
                break;
            case 2:
                logUser();
                //myUser.setLastname(myScanner.getInstance().getString());
                break;
            case 3:
                logger.info("Thank you for your visit");
                break;
        }
    }

    public void menuForCreateUser() {

        switch (option) {
            case 1:
                insertName();
                myUser.setName(myScanner.getInstance().getString());
                break;
            case 2:
                insertLastname();
                myUser.setLastName(myScanner.getInstance().getString());
                break;
            case 3:
                insertEmail();
                myUser.setEmail(myScanner.getInstance().getString());
                break;
            case 4:
                insertPassword();
                myUser.setPassword(myScanner.getInstance().getString());
                break;
            case 5:
                showFullName(myUser.getName(), myUser.getLastName());
                break;
            case 6:
                // salir del sistema
                break;
        }
    }

    public void captureOption() {
        option = myScanner.getInstance().getInteger();
    }
}
