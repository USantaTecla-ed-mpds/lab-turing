package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.date.Date;

public class ShiftServicesContractOption extends AskDateAndDoubleOption {

    public ShiftServicesContractOption(ServicesContract servicesContract) {
        super("Desplazar Horas del Contrato de Servicios", servicesContract);
    }


    public void interact_(Date date, Double factor) {
        this.servicesContract.shift(date,factor);
    }

}
