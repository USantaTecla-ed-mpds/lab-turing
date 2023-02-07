package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContract;

public interface Option {

    String show();

    void execute(ServicesContract servicesContract);
}
