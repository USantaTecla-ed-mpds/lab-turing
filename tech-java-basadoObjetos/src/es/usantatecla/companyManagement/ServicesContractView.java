package es.usantatecla.companyManagement;

import es.usantatecla.utils.Console;
import es.usantatecla.utils.Date;

public class ServicesContractView {

    private ServicesContract servicesContract;

    public ServicesContractView(ServicesContract servicesContract) {
        this.servicesContract = servicesContract;
    }

    public void cancel() {
        Date date = new DateView().getFromDayAndMonthUserInput(servicesContract.getYear());
        this.servicesContract.cancel(date);
    }

    public void enlarge() {
        Date date = new DateView().getFromDayAndMonthUserInput(servicesContract.getYear());
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
        Date date = new DateView().getFromDayAndMonthUserInput(servicesContract.getYear());
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

}
