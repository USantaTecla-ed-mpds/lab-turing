package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
<<<<<<< HEAD

public class CancelServicesContractOption extends DaterIntervalServiceContractOption {
=======
import main.es.pbover.utils.date.Date;


public class CancelServicesContractOption extends AskDateOption {
>>>>>>> 5fe23dff3ac7f1d9c97332c2832828acfa6b347a

    public CancelServicesContractOption(ServicesContract servicesContract) {
        super("Cancelar Horas del Contrato de Servicios", servicesContract);
    }

<<<<<<< HEAD
    @Override
    public void interact_() {
        servicesContract.cancel(this.date);
=======
    public void interact_(Date date) {
        this.servicesContract.cancel(date);
>>>>>>> 5fe23dff3ac7f1d9c97332c2832828acfa6b347a
    }
}
