package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public interface Option {

    String showTitle(int languaje);

    void execute(ServicesContractView servicesContractView);
}
