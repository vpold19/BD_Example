package com.skypro.test_demo_bd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;


@Entity
public class Reader {
    @Id
    @GeneratedValue
    private int personalNumber;

    private String firstName;
    private String secondName;
    private String middleName;
    @OneToMany(mappedBy = "reader")
    private Collection<Book> books;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return personalNumber == reader.personalNumber && Objects.equals(firstName, reader.firstName) && Objects.equals(secondName, reader.secondName) && Objects.equals(middleName, reader.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalNumber, firstName, secondName, middleName);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "personalNumber=" + personalNumber +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
