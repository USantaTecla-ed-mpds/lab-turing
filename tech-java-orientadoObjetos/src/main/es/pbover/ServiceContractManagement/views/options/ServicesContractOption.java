package main.es.pbover.ServiceContractManagement.views.options;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.menu.Option;

abstract class ServicesContractOption extends Option {

    protected ServicesContract servicesContract;

    public ServicesContractOption(String string, ServicesContract servicesContract) {
        super(string);
        this.servicesContract = servicesContract;
    }

}
