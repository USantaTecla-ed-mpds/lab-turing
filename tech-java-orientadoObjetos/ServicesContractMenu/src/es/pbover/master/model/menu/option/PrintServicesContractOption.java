package es.pbover.master.model.menu.option;

import es.pbover.master.model.ServicesContract;

class PrintServicesContractOption extends ServicesContractOption {

    public PrintServicesContractOption(ServicesContract servicesContract) {
        super("Imprimir Contratos de Servicios", servicesContract);
    }

    @Override
    public void interact() {
        this.servicesContract.writeln();
    }

}
