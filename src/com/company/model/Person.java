package com.company.model;

/**
 * Person model class
 */
public class Person {

    private Long idPerson;
    private String firstName;
    private String lastName;

    /**
     * Constructor person
     * @param idPerson
     * @param firstName
     * @param lastName
     */
    public Person(Long idPerson, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor
     */
    public Person(){}


    /**
     * getter id
     * @return id
     */
    public Long getIdPerson() {
        return idPerson;
    }

    /**
     * Setter id
     * @param idPerson
     */
    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    /**
     * Getter first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
