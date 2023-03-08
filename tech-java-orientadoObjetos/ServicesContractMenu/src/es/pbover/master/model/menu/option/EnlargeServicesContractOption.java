package es.pbover.master.model.menu.option;

import es.pbover.master.model.ServicesContract;
import es.pbover.master.utils.date.Date;
import es.pbover.master.utils.io.Console;
import es.pbover.master.utils.io.DateDialog;

public class EnlargeServicesContractOption extends ServicesContractOption {

    public EnlargeServicesContractOption(ServicesContract servicesContract) {
        super("Alargar Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Date date = new DateDialog().read(this.servicesContract.getYear());
        Double factor = Console.getInstance().readDouble("Introduzca el factor:");
        Console.getInstance().writeln();
        if(this.servicesContract.isIncluded(date)){
            this.servicesContract.enlarge(date, factor);
        } else {
            Console.getInstance().writeln("Fecha no incluida");
        }
        
    }

}
