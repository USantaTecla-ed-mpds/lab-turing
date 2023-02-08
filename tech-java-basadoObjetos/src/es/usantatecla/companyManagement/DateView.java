package es.usantatecla.companyManagement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.usantatecla.utils.Console;
import es.usantatecla.utils.Date;

public class DateView {
    
    private Date date;

    public Date getFromDayAndMonthUserInput(int year){
        Pattern pattern = Pattern.compile("^([0-2][0-9]|3[0-1])(/)(0[1-9]|1[0-2])");
        Matcher matcher;
        String userInputDate;
        do{
            userInputDate = new Console().readString("Día y mes [dd/mm]: ");
            matcher = pattern.matcher(userInputDate);
            if(!matcher.matches()){
                System.out.println("ERROR! Día y mes con el formato [dd/mm]");
            }
        }while(!matcher.matches());
        String[] separatedInput = userInputDate.split("/");
        int day = Integer.parseInt(separatedInput[0]);
        int month = Integer.parseInt(separatedInput[1]);
        this.date = new Date(day, month, year);
        return date;
    }
}
