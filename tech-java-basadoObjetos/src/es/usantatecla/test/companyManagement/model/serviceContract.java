package es.usantatecla.test.companyManagement.model;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import es.usantatecla.companyManagement.model.ServicesContract;

public class serviceContract {

    private ServicesContract servicesContract = new ServicesContract("test", 2023);;

    @Test
    public void givenNameWhenGetNameThenReturnSameName(){
        assertTrue(this.servicesContract.getName() == "test");
    }
    
}
