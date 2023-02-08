package es.usantatecla.companyManagement;

import es.usantatecla.companyManagement.menu.MenuView;

public class CompanyManagement {

	private final String CONTRACT_NAME = "Limpieza supermercado Dia";
	private final int YEAR = 2023;
	
    public static void main(String[] args) {
		new CompanyManagement().run();
	}

	private void run() {
		ServicesContract servicesContract = new ServicesContract(this.CONTRACT_NAME, this.YEAR);
		new MenuView(servicesContract).show();
	}
    
}
