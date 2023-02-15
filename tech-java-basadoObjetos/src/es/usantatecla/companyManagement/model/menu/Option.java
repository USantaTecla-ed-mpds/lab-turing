package es.usantatecla.companyManagement.model.menu;

import es.usantatecla.companyManagement.model.Languaje;
import es.usantatecla.companyManagement.view.ServicesContractView;

public interface Option {

    String showTitle(Languaje languaje);

    void execute(ServicesContractView servicesContractView);
}
