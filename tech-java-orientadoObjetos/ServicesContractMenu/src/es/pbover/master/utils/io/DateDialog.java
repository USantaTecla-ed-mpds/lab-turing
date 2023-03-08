package es.pbover.master.utils.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.pbover.master.utils.date.Date;
import es.pbover.master.utils.date.Month;

public class DateDialog {
    
    public Date read(int year) {
        Pattern pattern = Pattern.compile("^([0-2][0-9]|3[0-1])(/)(0[1-9]|1[0-2])");
        Matcher matcher;
        String userInputDate;
        do {
            userInputDate = Console.getInstance().readString("Inserte fecha dd/mm: ");
            matcher = pattern.matcher(userInputDate);
            if (!matcher.matches()) {
                System.out.println("Error!");
            }
        } while (!matcher.matches());
        String[] separatedInput = userInputDate.split("/");
        int day = Integer.parseInt(separatedInput[0]);
        Month month = Month.getMonth(Integer.parseInt(separatedInput[1]));
        return new Date(day, month, year);
    }
}
