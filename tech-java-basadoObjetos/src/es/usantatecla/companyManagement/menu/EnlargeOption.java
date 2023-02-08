package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.DateView;
import es.usantatecla.companyManagement.ServicesContract;
import es.usantatecla.utils.Console;
import es.usantatecla.utils.Date;

public class EnlargeOption implements Option{

    @Override
    public String showTitle() {
        return "Redimensionar (rango de horas)";
    }

    @Override
    public void execute(ServicesContract servicesContract) {
        Date date = new DateView().getFromDayAndMonthUserInput(servicesContract.getYear());
        double scale;
        boolean validScale = false;
        Console console = new Console();
        do{
            scale = console.readDouble("Multiplicador para redimensionar [ valor > 0.1 ]: ");
            if(scale > 0.1){
                validScale = true;
                servicesContract.enlarge(date, scale);
            } else {
                console.writeln("ERROR! Escalado incorrecto [ valor > 0.1 ]");
            }
        }while(!validScale);      
    }
    
}
