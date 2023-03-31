package main.es.labturing.ServiceContractManagement.views.options;

import main.es.labturing.ServiceContractManagement.models.ServicesContract;
import main.es.labturing.utils.views.Console;

public abstract class DateDialogAndDoubleOption extends DateDialogOption {

    protected double factor;

    public DateDialogAndDoubleOption(String string, ServicesContract servicesContract) {
        super(string, servicesContract);
    }

    public void interact() {

        this.factor = Console.getInstance().readDouble("Introduzca el factor:");
        super.interact();
    }

}
