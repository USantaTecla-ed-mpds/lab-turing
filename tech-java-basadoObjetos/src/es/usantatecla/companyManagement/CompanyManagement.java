package es.usantatecla.companyManagement;

import es.usantatecla.companyManagement.model.Languaje;
import es.usantatecla.companyManagement.model.ServicesContract;
import es.usantatecla.companyManagement.view.MenuView;
import es.usantatecla.companyManagement.view.ServicesContractView;

public class CompanyManagement {

	private final String CONTRACT_NAME = "Limpieza supermercado Dia";
	private final int YEAR = 2023;
	private final Languaje languaje = Languaje.SPANISH;
	private ServicesContract servicesContract;
	private ServicesContractView servicesContractView;

	private CompanyManagement() {
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
