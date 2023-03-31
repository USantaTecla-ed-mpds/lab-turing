package main.es.labturing.ServiceContractManagement.views.options;

import main.es.labturing.ServiceContractManagement.models.ServicesContract;
import main.es.labturing.utils.views.menu.Option;

abstract class ServicesContractOption extends Option {

    protected ServicesContract servicesContract;

    public ServicesContractOption(String string, ServicesContract servicesContract) {
        super(string);
        this.servicesContract = servicesContract;
    }

}
