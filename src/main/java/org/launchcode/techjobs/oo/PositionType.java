package org.launchcode.techjobs.oo;

public class PositionType {

    private int id;
    private static int nextId = 1;
    private String value;

    public PositionType() {
        id = nextId;
        nextId++;
    }

    public PositionType(String value) {
        this();
        this.value = value;
    }

    // TODO: Add a custom toString() method that returns the data stored in 'value'.
    @Override
    public String toString() {
        return value;
    }

    // TODO: Add custom equals and hashCode methods. Consider two PositionType
    // objects "equal" when
    // their id fields match.
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
        PositionType other = (PositionType) obj;
        if (id != other.id)
            return false;
        return true;
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
