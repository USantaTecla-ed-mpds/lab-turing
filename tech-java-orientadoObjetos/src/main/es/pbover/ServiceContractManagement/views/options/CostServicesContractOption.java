package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.Console;

public class CostServicesContractOption extends ServicesContractOption {

    public CostServicesContractOption(ServicesContract servicesContract) {
        super("Ver coste de Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Console.getInstance().writeln("Coste anual del contrato: " + servicesContract.getCost() + " Euros");

    }

}
