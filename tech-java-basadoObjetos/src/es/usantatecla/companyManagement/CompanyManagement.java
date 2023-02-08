package es.usantatecla.companyManagement;

import es.usantatecla.companyManagement.menu.MenuView;
import es.usantatecla.utils.Console;

public class CompanyManagement {

	private final String CONTRACT_NAME = "Limpieza supermercado Dia";
	private final int YEAR = 2023;
	
    public static void main(String[] args) {
		new CompanyManagement().run();
	}

	private void run() {
		ServicesContract servicesContract = new ServicesContract(this.CONTRACT_NAME, this.YEAR);
		new Console().writeln("Gestión del contrato \"" + servicesContract.getName() + "\" para el año " + servicesContract.getYear());
		new MenuView(servicesContract).show();
	}
    
}