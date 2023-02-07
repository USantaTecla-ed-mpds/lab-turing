package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;
import es.usantatecla.utils.Console;

public class GetCostOption implements Option{

    @Override
    public String showTitle() {
        return "Get total cost";
    }

    @Override
    public void execute(ServicesContract servicesContract) {
        new Console().writeln("\nCosto anual total: " + servicesContract.getCost() + "-euros\n");
        
    }


}
