package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class EnlargeOption implements Option{

    @Override
    public String showTitle() {
        return "Redimensionar (rango de horas)";
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.enlarge(); 
    }
    
}
