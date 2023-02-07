package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;
import es.usantatecla.utils.Console;
import es.usantatecla.utils.Date;

public class CancelOption implements Option{

    @Override
    public String showTitle() {
        return "Cancelar intervalo";   
    }

    @Override
    public void execute(ServicesContract servicesContract) {
        String userInputDate = new Console().readString("Día y mes [dd/mm]: ");
        //^([0-2][0-9]|3[0-1])(\/|-)(0[1-9]|1[0-2])
        //dia
        //mes
        //servidacc-getYear
        Date date = new Date();
        servicesContract.cancel(date);
    }
    
}
