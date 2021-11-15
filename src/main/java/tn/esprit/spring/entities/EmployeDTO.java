package tn.esprit.spring.entities;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class EmployeDTO {
    private int id;

    private String prenomDTO;

    private String nomDTO;

    private String emailDTO;

    private boolean isActifDTO;
    @Enumerated(EnumType.STRING)
    private Role roleDTO;

    public EmployeDTO(int id, String prenomDTO, String nomDTO, String emailDTO, boolean isActifDTO, Role roleDTO) {
        this.id = id;
        this.prenomDTO = prenomDTO;
        this.nomDTO = nomDTO;
        this.emailDTO = emailDTO;
        this.isActifDTO = isActifDTO;
        this.roleDTO = roleDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenomDTO() {
        return prenomDTO;
    }

    public void setPrenomDTO(String prenomDTO) {
        this.prenomDTO = prenomDTO;
    }

    public String getNomDTO() {
        return nomDTO;
    }

    public void setNomDTO(String nomDTO) {
        this.nomDTO = nomDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }

    public boolean isActifDTO() {
        return isActifDTO;
    }

    public void setActifDTO(boolean actifDTO) {
        isActifDTO = actifDTO;
    }

    public Role getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(Role roleDTO) {
        this.roleDTO = roleDTO;
    }
}
