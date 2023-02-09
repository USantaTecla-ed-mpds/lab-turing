package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.DateView;
import es.usantatecla.companyManagement.ServicesContract;

import es.usantatecla.utils.Date;

public class CancelOption implements Option{

    @Override
    public String showTitle() {
        return "Cancelar (fecha)";   
    }

    @Override
    public void execute(ServicesContract servicesContract) {
        Date date = new DateView().getFromDayAndMonthUserInput(servicesContract.getYear());
        servicesContract.cancel(date);
    }
    
}
