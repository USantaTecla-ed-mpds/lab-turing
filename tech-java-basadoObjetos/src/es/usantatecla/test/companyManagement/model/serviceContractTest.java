package es.usantatecla.test.companyManagement.model;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import es.usantatecla.companyManagement.model.ServicesContract;
import es.usantatecla.utils.Date;

public class serviceContractTest {

    private final ServicesContract servicesContract = new ServicesContract("test", 2023);;

    @Test
    public void givenNameWhenGetNameThenReturnSameName(){
        assertTrue(this.servicesContract.getName() == "test");
    }

    @Test
    public void givenServiceContractWhenNoActionThenReturCost(){
        double totalCost = 14400.0;  
        assertTrue(this.servicesContract.getCost() == totalCost);     
    }

    @Test
    public void givenCostWhenCancelDateThenReturReducedCost(){
        double totalCost = 14360.0;
        Date date = new Date(30, 12, 2023);
        this.servicesContract.cancel(date);
        assertTrue(this.servicesContract.getCost() == totalCost);     
    }
    
}
