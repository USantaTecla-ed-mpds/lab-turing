package main.es.pbover.ServiceContractManagement;

import main.es.pbover.ServiceContractManagement.models.ServicesContract;
import main.es.pbover.ServiceContractManagement.views.ServicesContractMenu;

public class ServiceContractManagement {

  private ServicesContract servicesContract; 
  private final static int YEAR = 2023; 

  public ServiceContractManagement(){
    this.servicesContract = new ServicesContract(ServiceContractManagement.YEAR);
  }

  public static void main(String[] args) {
    new ServiceContractManagement().interact();
  }

  private void interact(){
    new ServicesContractMenu(this.servicesContract).interact();
  }
}
