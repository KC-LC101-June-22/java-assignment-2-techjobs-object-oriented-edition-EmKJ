package org.launchcode.techjobs.oo.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    // Job job1 = new Job();
    // Job job2 = new Job();
    // Job job3 = new Job("Product tester", new Employer("ACME"), new
    // Location("Desert"),
    // new PositionType("Quality control"), new CoreCompetency("Persistence"));
    // Job job4 = new Job("Product Supervisor", new Employer(""), new
    // Location("Desert"),
    // new PositionType("Quality control"), new CoreCompetency("Persistence"));

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job2.getId(), job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().toString(), "ACME");
        assertEquals(job3.getLocation().toString(), "Desert");
        assertEquals(job3.getPositionType().toString(), "Quality control");
        assertEquals(job3.getCoreCompetency().toString(), "Persistence");

        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = job3.toString();
        assertEquals(testString.charAt(0), '\n');
        assertEquals(testString.charAt(testString.length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = job3.toString();
        String[] testLines = testString.trim().split("\\n");
        // assertTrue(testString.contains("ID: " + job3.getId()));
        // assertTrue(testString.contains("Name: " + job3.getName()));
        // assertTrue(testString.contains("Employer: " + job3.getEmployer()));
        // assertTrue(testString.contains("Location: " + job3.getLocation()));
        // assertTrue(testString.contains("Position Type: " + job3.getPositionType()));
        // assertTrue(testString.contains("Core Competency: " +
        // job3.getCoreCompetency()));
        assertEquals(testString,
                "\nID: 1\nName: Product Supervisor\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality Control\nCore Competency: Persistence\n");
        assertEquals(testLines.length, 6);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job4 = new Job("Product Supervisor", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        // String testString1 = job1.toString();
        // assertTrue(testString1.contains("OOPS! This job does not seem to exist."));

        String testString2 = job4.toString();
        // assertTrue(testString2.contains("Data not available"));
        assertEquals(testString2,
                "\nID: 5\nName: Product Supervisor\nEmployer: Data not available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }
}