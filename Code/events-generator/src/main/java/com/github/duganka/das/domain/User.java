package com.github.duganka.das.domain;

import com.github.duganka.das.util.CsvUtil;

/**
 * @author vadik
 */
public class User implements ToCsv {

    private final long id;
    private final String firstName;
    private final String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toCsv() {
        return CsvUtil.JOINER.join(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
