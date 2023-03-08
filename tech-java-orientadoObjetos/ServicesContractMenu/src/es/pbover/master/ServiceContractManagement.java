package es.pbover.master;

import es.pbover.master.model.menu.*;
import es.pbover.master.model.*;

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
