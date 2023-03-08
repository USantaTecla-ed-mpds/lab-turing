package es.pbover.master.model.menu.option;

import es.pbover.master.model.ServicesContract;
import es.pbover.master.utils.io.Console;

public class CostServicesContractOption extends ServicesContractOption {

    public CostServicesContractOption(ServicesContract servicesContract) {
        super("Ver coste de Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Console.getInstance().writeln();
        Console.getInstance().writeln("Coste anual del contrato: " + servicesContract.getCost() + " Euros");
        Console.getInstance().writeln(servicesContract.getCost() == 102200 ? "" : "ERROR!!!!");
    }

}
