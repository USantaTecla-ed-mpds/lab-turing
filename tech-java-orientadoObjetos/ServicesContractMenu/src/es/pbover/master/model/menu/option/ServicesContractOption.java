package es.pbover.master.model.menu.option;

import es.pbover.master.model.ServicesContract;

abstract class ServicesContractOption extends Option {

    protected ServicesContract servicesContract;

    public ServicesContractOption(String string, ServicesContract servicesContract) {
        super(string);
        this.servicesContract = servicesContract;
    }

}
