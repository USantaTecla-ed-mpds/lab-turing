package main.es.labturing.utils.views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.es.labturing.utils.models.date.Date;
import main.es.labturing.utils.models.date.Month;

public class DateDialog {

    private String message;

    public DateDialog(String message) {
        this.message = message;
    }

    public Date read(int year) {

        Matcher matcher;
        String userInputDate;
        do {
            userInputDate = Console.getInstance().readString(this.message);
            Pattern pattern = Pattern.compile("^([0-2][0-9]|3[0-1])(/)(0[1-9]|1[0-2])");
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
