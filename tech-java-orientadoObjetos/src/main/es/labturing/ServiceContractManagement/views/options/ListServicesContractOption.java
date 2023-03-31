package main.es.labturing.ServiceContractManagement.views.options;

import main.es.labturing.ServiceContractManagement.models.ServicesContract;
import main.es.labturing.ServiceContractManagement.views.ServicesContractView;
import main.es.labturing.utils.views.Console;

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
