package main.es.labturing.ServiceContractManagement.views;

import main.es.labturing.ServiceContractManagement.models.ServicesContract;
import main.es.labturing.ServiceContractManagement.views.options.CancelServicesContractOption;
import main.es.labturing.ServiceContractManagement.views.options.CostServicesContractOption;
import main.es.labturing.ServiceContractManagement.views.options.EnlargeServicesContractOption;
import main.es.labturing.ServiceContractManagement.views.options.ListServicesContractOption;
import main.es.labturing.ServiceContractManagement.views.options.ShiftServicesContractOption;
import main.es.labturing.utils.views.menu.IterativeMenu;

public class ServicesContractMenu extends IterativeMenu {

    private ServicesContract servicesContract;

    public ServicesContractMenu(ServicesContract servicesContract) {
        super("Gestión de Contratos de Servicios");
        this.servicesContract = servicesContract;
    }

    @Override
    protected void addOptions() {
        this.add(new ListServicesContractOption(this.servicesContract));
        this.add(new CostServicesContractOption(this.servicesContract));
        this.add(new CancelServicesContractOption(this.servicesContract));
        this.add(new EnlargeServicesContractOption(this.servicesContract));
        this.add(new ShiftServicesContractOption(this.servicesContract));
    }

}
