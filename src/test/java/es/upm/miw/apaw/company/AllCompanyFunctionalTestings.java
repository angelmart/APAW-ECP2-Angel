package es.upm.miw.apaw.company;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    CompanyResourceFunctionalTesting.class,
    StaffResourceFunctionalTesting.class
})
public class AllCompanyFunctionalTestings {

}
