package org.openmrs.reference;

import org.junit.After;
import org.junit.Before;
import org.openmrs.uitestframework.test.RestClient;
import org.openmrs.uitestframework.test.TestData;

import java.util.Arrays;

public class LocationSensitiveApplicationTestBase extends ReferenceApplicationTestBase {

    private String locationUuid;

    @Before
    public void createTaggedLocation() {
        String visit = TestData.getLocationTag("Visit");
        String login = TestData.getLocationTag("Login");
        String transfer = TestData.getLocationTag("Transfer");
        String admission = TestData.getLocationTag("Admission");

        String locationName = "Location" + TestData.randomSuffix();
        locationUuid = new TestData.TestLocation(locationName, Arrays.asList(visit, login)).create();

        goToLoginPage().loginAsAdmin(locationName);
    }

    @After
    public void deleteTestLocation(){
        RestClient.delete("location/"+locationUuid);
    }
}
