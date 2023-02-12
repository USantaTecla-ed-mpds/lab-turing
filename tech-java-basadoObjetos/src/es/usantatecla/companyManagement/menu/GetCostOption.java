package es.usantatecla.companyManagement.menu;

import es.usantatecla.companyManagement.ServicesContractView;

public class GetCostOption implements Option{

    @Override
    public String showTitle(int languaje) {
        return Languaje.TOTAL_COST.getTitle(languaje);
    }

    @Override
    public void execute(ServicesContractView servicesContractView) {
        servicesContractView.getCost();
    }


}
