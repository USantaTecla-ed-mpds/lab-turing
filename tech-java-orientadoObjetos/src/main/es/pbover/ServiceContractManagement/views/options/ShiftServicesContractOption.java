package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
<<<<<<< HEAD
import main.es.pbover.utils.Console;

public class ShiftServicesContractOption extends DaterAndFactorIntervalServiceContractOption {
=======
import main.es.pbover.utils.date.Date;

public class ShiftServicesContractOption extends AskDateAndDoubleOption {
>>>>>>> 5fe23dff3ac7f1d9c97332c2832828acfa6b347a

    public ShiftServicesContractOption(ServicesContract servicesContract) {
        super("Desplazar Horas del Contrato de Servicios", servicesContract);
    }

<<<<<<< HEAD
    @Override
    public void interact_() { 
        servicesContract.shift(this.date, this.factor);
    }        
=======

    public void interact_(Date date, Double factor) {
        this.servicesContract.shift(date,factor);
    }

>>>>>>> 5fe23dff3ac7f1d9c97332c2832828acfa6b347a
}
