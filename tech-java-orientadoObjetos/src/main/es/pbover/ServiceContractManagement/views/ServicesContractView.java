package main.es.pbover.ServiceContractManagement.views;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.utils.Console;
import main.es.pbover.utils.date.Date;
import main.es.pbover.utils.date.Month;

public class ServicesContractView {

	private ServicesContract servicesContract;

	public ServicesContractView(ServicesContract servicesContract) {
		this.servicesContract = servicesContract;
	}

	public void writeln() {
		Console console = new Console();
		console.writeln("Contrato de Servicios: " + this.servicesContract.getYear());
		Date date = new Date(1, Month.JANUARY, this.servicesContract.getYear());
		for (int i = 0; i < this.servicesContract.getTimetable().length; i++) {
			console.write("(" + (i + 1) + ") " + date.toString() + " - ");
			if (this.servicesContract.getTimetable()[i] == null) {
				console.writeln("Anulado");
			} else {
				console.writeln(this.servicesContract.getTimetable()[i].toString());
			}
			date = date.next();
		}
	}
}
