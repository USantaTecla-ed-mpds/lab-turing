package main.es.pbover.ServiceContractManagement;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.ServiceContractManagement.views.ServicesContractMenu;

public class ServiceContractManagement {

  private ServicesContract servicesContract; 
  private final int YEAR = 2023;
  private ServicesContractMenu servicesContractMenu;

  public ServiceContractManagement(){
    this.servicesContract = new ServicesContract(this.YEAR);
    this.servicesContractMenu = new ServicesContractMenu(this.servicesContract);
  }

  public static void main(String[] args) {
    new ServiceContractManagement().interact();
  }

  private void interact(){
    this.servicesContractMenu.interact();
  }
}
