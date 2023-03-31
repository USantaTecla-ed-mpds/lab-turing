package main.es.labturing.ServiceContractManagement.views.options;

import main.es.labturing.ServiceContractManagement.models.ServicesContract;
import main.es.labturing.utils.views.Console;

public class CostServicesContractOption extends ServicesContractOption {

    public CostServicesContractOption(ServicesContract servicesContract) {
        super("Ver coste de Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Console.getInstance().writeln("Coste anual del contrato: " + servicesContract.getCost() + " Euros");

    }

}
