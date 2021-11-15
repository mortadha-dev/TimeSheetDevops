package tn.esprit.spring.entities;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class EmployeDTO {
    private int id;

    private String firstname;

    private String lastname;

    private String adresseemail;

    private boolean estActif;
    @Enumerated(EnumType.STRING)
    private Role role;

    public EmployeDTO(int id, String firstname, String lastname, String adresseemail, boolean estActif, Role role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.adresseemail = adresseemail;
        this.estActif = estActif;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdresseemail() {
        return adresseemail;
    }

    public void setAdresseemail(String adresseemail) {
        this.adresseemail = adresseemail;
    }

    public boolean isEstActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
