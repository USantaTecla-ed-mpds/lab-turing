package es.pbover.master.model.menu.option;

import es.pbover.master.model.ServicesContract;
import es.pbover.master.utils.date.Date;
import es.pbover.master.utils.io.Console;
import es.pbover.master.utils.io.DateDialog;

public class CancelServicesContractOption extends ServicesContractOption {

    public CancelServicesContractOption(ServicesContract servicesContract) {
        super("Cancelar Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Date date = new DateDialog().read(this.servicesContract.getYear());
        Console.getInstance().writeln();

        if(this.servicesContract.isIncluded(date)){
            servicesContract.cancel(date);
        } else {
            Console.getInstance().writeln("Fecha no incluida");
        }
    }

}
