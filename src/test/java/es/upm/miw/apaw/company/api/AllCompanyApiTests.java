package es.upm.miw.apaw.company.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.upm.miw.apaw.company.api.controllers.AllCompanyApiControllersTests;
import es.upm.miw.apaw.company.api.daos.memory.AllCompanyApiDaosMemoryTests;
import es.upm.miw.apaw.company.api.dtos.AllCompanyApiDtosTests;
import es.upm.miw.apaw.company.api.entities.AllCompanyApiEntitiesTests;

@RunWith(Suite.class)
@SuiteClasses ({
    AllCompanyApiControllersTests.class,
    AllCompanyApiEntitiesTests.class,
    AllCompanyApiDtosTests.class,
    AllCompanyApiDaosMemoryTests.class
})
public class AllCompanyApiTests {

}
