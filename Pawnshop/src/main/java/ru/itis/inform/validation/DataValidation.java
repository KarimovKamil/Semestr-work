package ru.itis.inform.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kamil Karimov on 14.12.2016.
 */
@Component
public class DataValidation {

    public boolean verifyPhone(String phone) {
        Pattern pattern = Pattern.compile("[0-9]{11}");
        Matcher matcher = pattern.matcher(phone);
        return phone != null && matcher.matches();
    }

    public boolean verifyPassport(String passport) {
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher matcher = pattern.matcher(passport);
        return passport != null && matcher.matches();
    }
}
