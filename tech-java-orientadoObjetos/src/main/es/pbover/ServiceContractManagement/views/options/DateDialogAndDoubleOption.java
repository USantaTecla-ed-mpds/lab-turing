package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.Console;

public abstract class DateDialogAndDoubleOption extends DateDialogOption {

    protected double factor;

    public DateDialogAndDoubleOption(String string, ServicesContract servicesContract) {
        super(string, servicesContract);
    }

    public void interact() {

        this.factor = Console.getInstance().readDouble("Introduzca el factor:");
        super.interact();
    }

    public abstract void interact_();

}
