package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
public class EnlargeServicesContractOption extends DaterAndFactorIntervalServiceContractOption {

    public EnlargeServicesContractOption(ServicesContract servicesContract) {
        super("Alargar horas del Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact_() {
        this.servicesContract.enlarge(this.date, this.factor);
    }    
}
