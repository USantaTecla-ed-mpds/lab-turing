package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class GetCostOption implements Option{

    @Override
    public String showTitle() {
        return "Costo total";
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.getCost();
    }


}
