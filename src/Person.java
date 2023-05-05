import java.time.LocalDate;

public class Person {
    private String firstname;
    private String lastname;
    private LocalDate birth;
    private String gender;
    private String personalCode;

    public Person(String firstname, String lastname, LocalDate birth, String gender, String personalCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
        this.gender = gender;
        this.personalCode = personalCode;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public String getPersonalCode() {
        return personalCode;
    }
}
