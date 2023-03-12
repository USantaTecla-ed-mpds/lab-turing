package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.date.Date;


public class EnlargeServicesContractOption extends AskDateAndDoubleOption {

    public EnlargeServicesContractOption(ServicesContract servicesContract) {
        super("Escalar Horas del Contrato de Servicios", servicesContract);
    }

    public void interact_(Date date,Double factor) {
        this.servicesContract.enlarge(date,factor);
    }

}
