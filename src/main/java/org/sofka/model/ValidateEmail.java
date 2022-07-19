package org.sofka.model;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    public static void main(String[] args) {
        ValidateEmail validateEmail = new ValidateEmail();

        if(validateEmail.ValidateEmail("nana@mail.com")){
            JOptionPane.showMessageDialog(null, "Correct");
        } else{
            JOptionPane.showMessageDialog(null, "Incorrect");
        }
    }
    public boolean ValidateEmail(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z09+]=(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
