package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;

public class CancelServicesContractOption extends DaterIntervalServiceContractOption {

    public CancelServicesContractOption(ServicesContract servicesContract) {
        super("Cancelar Horas del Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact_() {
        servicesContract.cancel(this.date);
    }
}
