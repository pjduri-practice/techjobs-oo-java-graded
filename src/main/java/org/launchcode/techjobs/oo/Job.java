package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        if (JobField.testEmptyValue(name)) {
            name = "Data not available";
        }
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {

        int emptyFields = 0;
        ArrayList fieldsArray = new ArrayList<>();
        fieldsArray.add(this.name);
        fieldsArray.add(this.employer);
        fieldsArray.add(this.location);
        fieldsArray.add(this.positionType);
        fieldsArray.add(this.coreCompetency);
        for (Object item : fieldsArray) {
            if (item.toString().equals("Data not available")) {
                emptyFields++;
            }
        }

        if (emptyFields >= fieldsArray.size()) {
            return "OOPS! This job does not seem to exist.";
        } else {
            return  "\n" +
                    "ID: " + this.getId() + "\n" +
                    "Name: " + this.getName() + "\n" +
                    "Employer: " + this.getEmployer() + "\n" +
                    "Location: " + this.getLocation() + "\n" +
                    "Position Type: " + this.getPositionType() + "\n" +
                    "Core Competency: " + this.getCoreCompetency() + "\n";
        }
    }

}
