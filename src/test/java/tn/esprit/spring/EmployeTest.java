package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SpringBootTest
class EmployeTest {
    /*
    @Autowired
    private EmployeServiceImpl employeService;
    private final static Logger l = LogManager.getLogger(EmployeTest.class);

    @Test
    void ajoutEmploye() {

        Assertions.assertSame(52,789);
        l.info("l'employé est ajouté");
    }

    @Test
    void getAllEmployeNamesJPQL() {
        l.info("les noms des employés sont : " + employeService.getAllEmployeNamesJPQL());
    }

    @Test
    void getNombreEmploye() {
        int nombre = employeService.getNombreEmployeJPQL();
        l.info("le nombre des employés est : " + nombre);
    }

    @Test
    void AjouterContrat() {
        Contrat contrat = new Contrat();
        contrat.setSalaire(2000);
        Date date = new Date();
        contrat.setDateDebut(date);
        contrat.setReference(12);
        contrat.setTypeContrat("CDI");
        Assertions.assertEquals(2000, contrat.getSalaire());
        employeService.ajouterContrat(contrat);
        l.info(" le contrat est bien ajouté");
    }

    @Test
    void affecterContratAEmploye() {
        int contratid = 1;
        int employeid = 1;
        employeService.affecterContratAEmploye(contratid, employeid);
        l.info("le contrat d'id" + contratid + "est bien affecté à l'employé d'id: " + employeid);
    }

    @Test
    void affecterEmployeADepartement() {
        int employeId = 1;
        int departmentId = 1;
        employeService.affecterEmployeADepartement(employeId, departmentId);
        l.info("l'employé qui a l'id: " + employeId + " est affecté au département avec l'id : " + departmentId);
    }
    @Test
    void getSalaireByEmployeIdJPQL(){
        int employeId = 1 ;
     float salaire=   employeService.getSalaireByEmployeIdJPQL(employeId) ;
        l.info("l'employé d'id: "+ employeId+ " a un salaire de "+ salaire);

    }

    @Test
    void DesaffecterEmployeDuDepartement() {
        int employeId = 1;
        int departmentId = 1;
        employeService.desaffecterEmployeDuDepartement(employeId, departmentId);
        l.info("l'employé qui a l'id : " + employeId + " est désaffecté du département qui a l'id : " + departmentId);
    }

    @Test
    void DeleteContrat() {
        employeService.deleteContratById(1);
        l.info("Le contrat est supprimé");
    }

    @Test
    void DeleteEmploye() {
        employeService.deleteEmployeById(1);
        l.info("l'employé est supprimé");
    }

    @Test
    void DeleteAllContrat() {
        employeService.deleteAllContratJPQL();

        l.info("tous les contrats sont supprimés");

    }

*/
}

