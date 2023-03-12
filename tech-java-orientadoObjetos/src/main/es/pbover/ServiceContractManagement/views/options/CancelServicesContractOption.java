package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.date.Date;


public class CancelServicesContractOption extends AskDateOption {

    public CancelServicesContractOption(ServicesContract servicesContract) {
        super("Cancelar Horas del Contrato de Servicios", servicesContract);
    }

    public void interact_(Date date) {
        this.servicesContract.cancel(date);
    }

}
