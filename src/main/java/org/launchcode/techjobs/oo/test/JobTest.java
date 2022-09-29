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

    private Job job1, job2, productTester, productTester1, productTester2;
    @Before
    public void createTestJobs() {
        job1 = new Job();
        job2 = new Job();
        productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        productTester1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        productTester2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId(){
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
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
        Job job = new Job();
        String jobString = job.toString();
//        Character firstNewline = job.toString().charAt(0);
//        Character lastNewline = job.toString().charAt(job2.toString().length()-1);
        assertEquals(jobString.charAt(0), '\n');
        assertEquals(jobString.charAt(jobString.length()-1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        assertEquals(productTester.toString(), "\n" +
                "ID:  3\n" +
                "Name:  Product tester\n" +
                "Employer:  ACME\n" +
                "Location:  Desert\n" +
                "Position Type:  Quality control\n" +
                "Core Competency:  Persistence\n");
    }

//    @Test
//    public void testToStringHandlesOnlyId() {
//        assertEquals(job1.toString(), "OOPS! This job does not seem to exist.");
//    }

//    ID:  _______
//    Name: _______
//    Employer: _______
//    Location: _______
//    Position Type: _______
//    Core Competency: _______

}
