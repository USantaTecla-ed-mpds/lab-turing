package es.usantatecla.companyManagement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.usantatecla.utils.Console;
import es.usantatecla.utils.Date;

public class ServicesContractView {

    private ServicesContract servicesContract;

    public ServicesContractView(ServicesContract servicesContract) {
        this.servicesContract = servicesContract;
    }

    public void cancel() {
        Date date = this.getDateFromDayAndMonthUserInput(this.servicesContract.getYear());
        this.servicesContract.cancel(date);
    }

    public void enlarge() {
        Date date = this.getDateFromDayAndMonthUserInput(this.servicesContract.getYear());
        double scale;
        boolean validScale = false;
        Console console = new Console();
        do{
            scale = console.readDouble("Multiplicador para redimensionar [ valor > 0.1 ]: ");
            if(scale > 0.1){
                validScale = true;
                this.servicesContract.enlarge(date, scale);
            } else {
                console.writeln("ERROR! Escalado incorrecto [ valor > 0.1 ]");
            }
        }while(!validScale); 
    }

    public void shift() {
        Date date = this.getDateFromDayAndMonthUserInput(this.servicesContract.getYear());
        double shiftment;
        boolean validShifment = false;
        Console console = new Console();
        do{
            shiftment = console.readDouble("Valor para desplazar [ valor > 0 ]: ");
            if(shiftment > 0){
                validShifment = true;
                this.servicesContract.shift(date, shiftment);
            } else {
                console.writeln("ERROR! desplazamiento incorrecto [ valor > 0 ]");
            }
        }while(!validShifment);    
    }

    public void exit() {
        new Console().writeln("\nHasta la próxima!");
    }

    public void getCost() {
        new Console().writeln("\nCosto anual total: " + this.servicesContract.getCost() + "-euros\n");
    }

    public String getName() {
        return this.servicesContract.getName();
    }

    public void writeln() {
        this.servicesContract.writeln();
    }

    public int getYear() {
        return this.servicesContract.getYear();
    }

    private Date getDateFromDayAndMonthUserInput(int year){
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
        return new Date(day, month, year);
    }
}
