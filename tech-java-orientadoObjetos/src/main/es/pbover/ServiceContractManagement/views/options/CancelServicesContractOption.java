package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.Console;
import main.es.pbover.utils.date.Date;
import main.es.pbover.utils.date.DateDialog;

public class CancelServicesContractOption extends ServicesContractOption {

    public CancelServicesContractOption(ServicesContract servicesContract) {
        super("Cancelar Horas del Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Date date = new DateDialog("Inserte fecha dd/mm: ").read(this.servicesContract.getYear());
        Console.getInstance().writeln();

        if (this.servicesContract.containsInterval(date)) {
            servicesContract.cancel(date);
        } else {
            Console.getInstance().writeln("Fecha sin horas en el contrato");
        }
    }

}
