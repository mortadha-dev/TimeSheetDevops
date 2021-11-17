package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.exceptions.ResourceNotFoundException;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartementServiceImpl implements IDepartementService{

    @Autowired
    EntrepriseRepository entrepriseRepoistory;
    @Autowired
    DepartementRepository deptRepoistory;

    private  String message ;

    public int ajouterDepartement(Departement dep) {
        deptRepoistory.save(dep);
        return dep.getId();
    }

    public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {

        var entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElseThrow(() -> new ResourceNotFoundException(message + entrepriseId));
        List<String> depNames = new ArrayList<>();
        for(Departement dep : entrepriseManagedEntity.getDepartements()){
            depNames.add(dep.getName());
        }

        return depNames;
    }

    public Departement getDepartementById(int depId){
        return deptRepoistory.findById(depId).orElseThrow(() -> new ResourceNotFoundException(message + depId));
    }


    public List<Departement> getAllDepartement(){

        return (List<Departement>) deptRepoistory.findAll();
    }
    @Transactional
    public void deleteDepartementById(int depId) {
        deptRepoistory.delete(deptRepoistory.findById(depId).orElseThrow(() -> new ResourceNotFoundException("departement not found with this id : " + depId)));
    }

    public void deleteAllDepartement(){
        deptRepoistory.deleteAll();
    }
}
