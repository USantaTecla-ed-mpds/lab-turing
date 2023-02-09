package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public interface Option {

    String showTitle();

    void execute(ServicesContractView servicesContractView);
}
