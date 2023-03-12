package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.Console;

public abstract class DaterAndFactorIntervalServiceContractOption extends DaterIntervalServiceContractOption{

    protected double factor;

    public DaterAndFactorIntervalServiceContractOption(String string, ServicesContract servicesContract) {
        super(string, servicesContract);
    }

    @Override
    public void interact(){
        this.factor = Console.getInstance().readDouble("Introduzca el factor: ");
        super.interact();
    }
    
}
