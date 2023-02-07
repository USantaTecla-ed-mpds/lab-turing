package es.usantatecla.companyManagement;

import es.usantatecla.companyManagement.menu.Menu;
import es.usantatecla.utils.Console;

public class CompanyManagement {

	private final String COMPANY_NAME = "Santa Tecla Corp.";
	private final int YEAR = 2023;

    public static void main(String[] args) {
		new CompanyManagement().run();
	}

	private void run() {
		ServicesContract servicesContract = new ServicesContract(this.COMPANY_NAME, this.YEAR);
		new Console().writeln("Gestión contratos de " + servicesContract.getName() + " para el año " + servicesContract.getYear());
		new Menu(servicesContract).show();
	}
    
}
