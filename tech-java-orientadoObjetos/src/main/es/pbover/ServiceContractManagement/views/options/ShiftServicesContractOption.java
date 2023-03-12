package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.Console;

public class ShiftServicesContractOption extends DaterAndFactorIntervalServiceContractOption {

    public ShiftServicesContractOption(ServicesContract servicesContract) {
        super("Desplazar Horas del Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact_() { 
        servicesContract.shift(this.date, this.factor);
    }        
}
