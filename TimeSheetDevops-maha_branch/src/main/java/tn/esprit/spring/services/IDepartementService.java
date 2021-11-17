package tn.esprit.spring.services;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

import java.util.List;

public interface IDepartementService {

    public int ajouterDepartement(Departement dep);
    List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
    public Departement getDepartementById(int depId);
    public List<Departement> getAllDepartement();
    public void deleteDepartementById(int depId);
    public void deleteAllDepartement();
}
