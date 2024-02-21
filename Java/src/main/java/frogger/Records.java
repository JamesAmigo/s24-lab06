package frogger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Refactor Task 2.
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Records {
    private final Set<SingleRecord> records;

    public Records() 
    {
        this.records = new HashSet<>();
    }

    /**
     * Adds a frogger's record.
     *
     * @param firstName   first name of the frogger
     * @param lastName    last name of the frogger
     * @param phoneNumber phone number of the frogger
     * @param zipCode     zip code of the frogger
     * @param state       state of the frogger
     * @param gender      gender of the frogger
     * @return Return false if the record has existed. Else, return true.
     */
    public boolean addRecord(String firstName, String lastName, String phoneNumber, String zipCode, String state, String gender) 
    {
        return records.add(new SingleRecord(firstName, lastName, phoneNumber, zipCode, state, gender));
    }

    private static class SingleRecord {
        String firstName, lastName, phoneNumber, zipCode, state, gender;

        SingleRecord(String firstName, String lastName, String phoneNumber, String zipCode, String state, String gender) 
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.zipCode = zipCode;
            this.state = state;
            this.gender = gender;
        }

        //This equals method makes sure that when two records have the same information, they are considered equal.
        @Override
        public boolean equals(Object o) 
        {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass()) 
                return false;
            SingleRecord record = (SingleRecord) o;
            return firstName.equals(record.firstName) &&
                    lastName.equals(record.lastName) &&
                    phoneNumber.equals(record.phoneNumber) &&
                    zipCode.equals(record.zipCode) &&
                    state.equals(record.state) &&
                    gender.equals(record.gender);
        }

        //This hashCode method makes sure every record with the same information has the same hash code.
        @Override
        public int hashCode() 
        {
            return Objects.hash(firstName, lastName, phoneNumber, zipCode, state, gender);
        }
    }
}