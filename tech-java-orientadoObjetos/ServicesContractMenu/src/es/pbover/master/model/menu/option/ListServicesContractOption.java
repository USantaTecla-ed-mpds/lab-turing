package es.pbover.master.model.menu.option;

import es.pbover.master.model.ServicesContract;
import es.pbover.master.utils.io.Console;

public class ListServicesContractOption extends ServicesContractOption {

    public ListServicesContractOption(ServicesContract servicesContract) {
        super("Listado Contratos de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Console.getInstance().writeln();
        this.servicesContract.writeln();
    }

}
