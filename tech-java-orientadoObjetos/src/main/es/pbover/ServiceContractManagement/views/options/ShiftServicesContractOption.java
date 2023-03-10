package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.Console;
import main.es.pbover.utils.date.Date;
import main.es.pbover.utils.date.DateDialog;

public class ShiftServicesContractOption extends ServicesContractOption {

    public ShiftServicesContractOption(ServicesContract servicesContract) {
        super("Desplazar Horas del Contrato de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        Date date = new DateDialog("Inserte fecha dd/mm: ").read(this.servicesContract.getYear());
        Double shiftment = Console.getInstance().readDouble("Introduzca el desplazamiento:");
        Console.getInstance().writeln();

        if(this.servicesContract.containsInterval(date)){
            servicesContract.shift(date, shiftment);
        } else {
            Console.getInstance().writeln("Fecha sin horas en el contrato");
        }
        
    }

}
