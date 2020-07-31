

import java.util.Objects;

public class PersonData implements Cloneable {
    private String lastName;
    private String firstName;
    private String address;
    private String phone;

    public PersonData() {
        this.lastName = "";
        this.firstName = "";
        this.address = "";
        this.phone = "";
    }

    public PersonData(String firstName, String lastName, String address, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "First name: " + firstName + "; Last name: " + lastName + "; Address: " + address + "; Phone: " + phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonData that = (PersonData) o;
        return Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public PersonData clone() {
        try {
            return (PersonData) super.clone();
        } catch (CloneNotSupportedException ignored) {
            System.out.println("[ERROR] Clone Not Supported.");
            System.out.println(toString());
            System.exit(1);
        }
        System.out.println("[ERROR] Should be unreachable, " +
                "line uid: 8D70501A-4D67-400F-8B9E-853A414907B8");
        return null; // Should be unreachable
    }

    /**
     * Getter
     *
     * @return lastName as String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter - lastName
     *
     * @param lastName lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter
     *
     * @return firstName as String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter - firstName
     *
     * @param firstName firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter
     *
     * @return address as String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter - address
     *
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter
     *
     * @return phoneNumber as String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter - phone
     *
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
