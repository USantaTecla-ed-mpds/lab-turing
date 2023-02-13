package es.usantatecla.companyManagement;

import es.usantatecla.companyManagement.menu.Languaje;
import es.usantatecla.companyManagement.menu.MenuView;

public class CompanyManagement {

	private final String CONTRACT_NAME = "Limpieza supermercado Dia";
	private final int YEAR = 2023;
	private final Languaje languaje = Languaje.SPANISH;
	private final ServicesContract servicesContract;
	private final ServicesContractView servicesContractView;

	private CompanyManagement(){
		this.servicesContract = new ServicesContract(this.CONTRACT_NAME, this.YEAR);
		this.servicesContractView = new ServicesContractView(servicesContract, this.languaje);
	}
	
    public static void main(String[] args) {
		new CompanyManagement().run();
	}

	private void run() {
		new MenuView(servicesContractView).show(this.languaje);
	}
    
}
