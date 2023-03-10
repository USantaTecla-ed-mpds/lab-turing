package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.Console;
import main.es.pbover.utils.date.Date;
import main.es.pbover.utils.date.DateDialog;

public class EnlargeServicesContractOption extends ServicesContractOption {

    public EnlargeServicesContractOption(ServicesContract servicesContract) {
        super("Alargar Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Date date = new DateDialog("Inserte fecha dd/mm: ").read(this.servicesContract.getYear());
        Double factor = Console.getInstance().readDouble("Introduzca el factor:");
        Console.getInstance().writeln();
        if(this.servicesContract.containsInterval(date)){
            this.servicesContract.enlarge(date, factor);
        } else {
            Console.getInstance().writeln("Fecha no incluida");
        }
        
    }

}
