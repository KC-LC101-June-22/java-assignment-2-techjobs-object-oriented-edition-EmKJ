package org.launchcode.techjobs.oo;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to
    // initialize the
    // other five fields. The second constructor should also call the first in order
    // to initialize
    // the 'id' field.
    public Job() {
        id = nextId;
        nextId++;

    }

    public Job(String name, Employer employer, Location location, PositionType positionType,
            CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String stringToPrint = String.format(
                "\nID: %d\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: %s\nCore Competency: %s\n",
                id, noDataFound(name), noDataFound(employer.getValue()), noDataFound(location.getValue()),
                noDataFound(positionType.getValue()), noDataFound(coreCompetency.getValue()));
        String[] splitString = stringToPrint.split("Data not available");

        if (splitString.length == 6) {
            return "ID: " + id + "\nOOPS! This job does not seem to exist.\n";
        }
        return stringToPrint;
    }

    public String noDataFound(String field) {
        if (field.trim().length() < 1) {
            return "Data not available";
        }
        return field;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects
    // "equal" when their id fields
    // match.

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

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field
    // EXCEPT nextID
    // and id.
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Job other = (Job) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
