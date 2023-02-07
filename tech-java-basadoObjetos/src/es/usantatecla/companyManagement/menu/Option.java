package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;

public interface Option {

    String showTitle();

    void execute(ServicesContract servicesContract);
}
