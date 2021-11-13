package tn.esprit.spring;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.services.EntrepriseServiceImpl;


@SpringBootTest
class EmployeTest {
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private EmployeServiceImpl employeService;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    EntrepriseServiceImpl entrepriseService;
    private final static Logger l = LogManager.getLogger(EmployeTest.class);

    @Test
    void ajoutEmploye() {
        var employe = new Employe("ahmed", "bouallagui", "ahmed@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        long start = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - start;
        l.info("Method execution time: " + elapsedTime + " milliseconds.");
        l.info("l'employé est ajouté");
    }

    @Test
    void getNombreEmploye() {
        int nombre = employeService.getNombreEmployeJPQL();
        var employe = new Employe("ahmed", "bouallagui", "ahmed@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        int secondNombre = employeService.getNombreEmployeJPQL();
        Assertions.assertNotEquals(nombre, secondNombre);
        l.info("le nombre des employés est : " + nombre);
    }

    @Test
    void AjouterContrat() {
        Date date = new Date();
        Contrat contrat = new Contrat(date, "CDI", 20000);
        int resultat = employeService.ajouterContrat(contrat);
        Assertions.assertEquals(resultat, contrat.getReference() );
        l.info(" le contrat est bien ajouté");
    }

    @Test
    void affecterContratAEmploye() {
        var employe = new Employe("ahmed", "bouallagui", "ahmed@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        Date date = new Date();
        var contrat = new Contrat(date, "CDD", 1000);
        employeService.ajouterEmploye(employe);
        float primesalaire=  employeService.getSalaireByEmployeIdJPQL(employe.getId());
        employeService.ajouterContrat(contrat);
        employeService.affecterContratAEmploye(contrat.getReference(), employe.getId());
        float secondsalaire=  employeService.getSalaireByEmployeIdJPQL(employe.getId());
        Assertions.assertNotEquals(primesalaire, secondsalaire);
        l.info("le contrat d'id" + contrat.getReference() + "est bien affecté à l'employé d'id: " + employe.getId());
    }

    @Test
    void affecterEmployeADepartement() {
        var employe = new Employe("ahmed", "bouallagui", "ahmed@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        var departement = new Departement("testing");
        entrepriseService.ajouterDepartement(departement);
        int nombreEmployees = employeService.getAllEmployeByDepartement(departement.getId()) ;
        employeService.affecterEmployeADepartement(employe.getId(), departement.getId());
        int nombreEmployeesAfterAdding = employeService.getAllEmployeByDepartement(departement.getId()) ;
        Assertions.assertNotEquals(nombreEmployees, nombreEmployeesAfterAdding);
        l.info("l'employé qui a l'id: " + employe.getId() + " est affecté au département avec l'id : " + departement.getId());
    }

    @Test
    void getSalaireByEmployeIdJPQL() {
        var employe = new Employe("ahmed", "bouallagui", "ahmed@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        Date date = new Date();
        var contrat = new Contrat(date, "CDD", 1000);
        employeService.ajouterContrat(contrat);
        employeService.affecterContratAEmploye(contrat.getReference(), employe.getId());
        float salaire1=0 ;
        float salaire = employeService.getSalaireByEmployeIdJPQL(employe.getId());
        Assertions.assertNotEquals(salaire, salaire1);
        l.info("l'employé d'id: " + employe.getId() + " a un salaire de " + salaire);
    }

    @Test
    void DesaffecterEmployeDuDepartement() {
        var employe = new Employe("ahmed", "bouallagui", "ahmed@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        var entreprise = new Entreprise("premiére entreprise", "raison");
        var departement = new Departement("Geo");
        departement.setEntreprise(entreprise);
        entrepriseService.ajouterEntreprise(entreprise);
        entrepriseService.ajouterDepartement(departement);
        employeService.affecterEmployeADepartement(employe.getId(), departement.getId());
        int nombreEmployees = employeService.getAllEmployeByDepartement(departement.getId()) ;
        employeService.desaffecterEmployeDuDepartement(employe.getId(), departement.getId());
        int nombreEmployeesAfterDesaff = employeService.getAllEmployeByDepartement(departement.getId()) ;
        Assertions.assertNotEquals(nombreEmployees, nombreEmployeesAfterDesaff);
        l.info("l'employé qui a l'id : " + employe.getId() + " est désaffecté du département qui a l'id : " + departement.getId());
    }

    @Test
    @Order(8)
    void DeleteContrat() {
        Date date = new Date();
        var contrat = new Contrat(date, "CDD", 1000);
        employeService.ajouterContrat(contrat);
        boolean existBeforeDelete = contratRepository.findById(contrat.getReference()).isPresent();
        employeService.deleteContratById(contrat.getReference());
        boolean existAfterDelete = contratRepository.findById(contrat.getReference()).isPresent();
        Assert.assertTrue(existBeforeDelete);
        Assert.assertFalse(existAfterDelete);
        l.info("Le contrat est supprimé");
    }

    @Test
    void DeleteEmploye() {
        var employe = new Employe("ahmed", "bouallagui", "ahmed@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        boolean existBeforeDelete = employeRepository.findById(employe.getId()).isPresent();
        Assert.assertTrue(existBeforeDelete);
        employeService.deleteEmployeById(employe.getId());
        boolean existAfterDelete = employeRepository.findById(employe.getId()).isPresent();
        Assert.assertFalse(existAfterDelete);
        l.info("L'employé est supprimé");
    }

    @Test
    void DeleteAllContrat() {
        employeService.deleteAllContratJPQL();
        Assert.assertEquals("[]", contratRepository.findAll().toString());
        l.info("tous les contrats sont supprimés");
    }
}