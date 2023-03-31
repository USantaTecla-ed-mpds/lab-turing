package main.es.labturing.ServiceContractManagement.views.options;

import main.es.labturing.ServiceContractManagement.models.ServicesContract;
import main.es.labturing.utils.models.date.Date;
import main.es.labturing.utils.views.Console;
import main.es.labturing.utils.views.DateDialog;

public abstract class DateDialogOption extends ServicesContractOption {

    protected Date date;

    public DateDialogOption(String string, ServicesContract servicesContract) {
        super(string, servicesContract);
    }

    @Override
    public void interact() {
        this.date = new DateDialog("Inserte fecha dd/mm: ").read(this.servicesContract.getYear());
        Console.getInstance().writeln();

        if (this.servicesContract.containsInterval(date)) {
            this.interact_();
        } else {
            Console.getInstance().writeln("Fecha sin horas en el contrato");
        }

    }

    public abstract void interact_();

}
