package tn.esprit.spring.entities;

import java.util.Date;

public class ContratDTO {

   private Date dateDebutDTO;

    private String typeContratDTO;

   private float salaireDTO;

    public Date getDateDebutDTO() {
        return dateDebutDTO;
    }

    public void setDateDebutDTO(Date dateDebutDTO) {
        this.dateDebutDTO = dateDebutDTO;
    }

    public String getTypeContratDTO() {
        return typeContratDTO;
    }

    public void setTypeContratDTO(String typeContratDTO) {
        this.typeContratDTO = typeContratDTO;
    }

    public float getSalaireDTO() {
        return salaireDTO;
    }

    public void setSalaireDTO(float salaireDTO) {
        this.salaireDTO = salaireDTO;
    }
}
