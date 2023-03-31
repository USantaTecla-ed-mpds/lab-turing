package main.es.labturing.ServiceContractManagement.views.options;

import main.es.labturing.ServiceContractManagement.models.ServicesContract;

public class ShiftServicesContractOption extends DateDialogAndDoubleOption {

    public ShiftServicesContractOption(ServicesContract servicesContract) {
        super("Desplazar Horas de un día del Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact_() {
        servicesContract.shift(this.date, this.factor);
    }
}
