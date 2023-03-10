package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.ServiceContractManagement.views.ServicesContractView;
import main.es.pbover.utils.Console;

public class ListServicesContractOption extends ServicesContractOption {

    public ListServicesContractOption(ServicesContract servicesContract) {
        super("Listado Contratos de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Console.getInstance().writeln();
        new ServicesContractView(this.servicesContract).writeln();
    }

}
