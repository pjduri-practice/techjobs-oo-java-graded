package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    private Job productTester1, productTester2;
    @Before
    public void createTestJobs() {
        productTester1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        productTester2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(productTester.toString(), "\n" +
                "ID: 8\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n");
    }
    @Test
    public void testSettingJobId(){
        assertNotEquals(productTester1.getId(), productTester2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(productTester instanceof Job);
        assertEquals(productTester.getName().toString(), "Product tester");
        assertTrue(productTester.getEmployer() instanceof Employer);
        assertEquals(productTester.getEmployer().toString(), "ACME");
        assertTrue(productTester.getLocation() instanceof Location);
        assertEquals(productTester.getLocation().toString(), "Desert");
        assertTrue(productTester.getPositionType() instanceof PositionType);
        assertEquals(productTester.getPositionType().toString(), "Quality control");
        assertTrue(productTester.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(productTester.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(productTester1.equals(productTester2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("DoorDasher", new Employer("Doordash"),
                new Location("Literally anywhere"), new PositionType("Delivery"),
                new CoreCompetency("Driving"));
        String jobString = job.toString();
        assertEquals(jobString.charAt(0), '\n');
        assertEquals(jobString.charAt(jobString.length()-1), '\n');
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobSomeEmpty = new Job("", new Employer("Archimoto"), new Location("Home"), new PositionType(""), new CoreCompetency(""));
        assertEquals(jobSomeEmpty.toString(), "\n" +
                "ID: 5\n" +
                "Name: Data not available\n" +
                "Employer: Archimoto\n" +
                "Location: Home\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n");
    }

    @Test
    public void testToStringHandlesOnlyId() {
        Job job1 = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
        assertEquals(job1.toString(), "OOPS! This job does not seem to exist.");
    }

}
