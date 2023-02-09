package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.DateView;
import es.usantatecla.companyManagement.ServicesContract;
import es.usantatecla.utils.Console;
import es.usantatecla.utils.Date;

public class ShiftOption implements Option{

    @Override
    public String showTitle() {
        return "Desplazar (rango de horas)";
    }

    @Override
    public void execute(ServicesContract servicesContract) {//opcion acoplada a console
        Date date = new DateView().getFromDayAndMonthUserInput(servicesContract.getYear());
        double shiftment;
        boolean validShifment = false;
        Console console = new Console();
        do{
            shiftment = console.readDouble("Valor para desplazar [ valor > 0 ]: ");
            if(shiftment > 0){
                validShifment = true;
                servicesContract.shift(date, shiftment);
            } else {
                console.writeln("ERROR! desplazamiento incorrecto [ valor > 0 ]");
            }
        }while(!validShifment);            
    }
    
}
