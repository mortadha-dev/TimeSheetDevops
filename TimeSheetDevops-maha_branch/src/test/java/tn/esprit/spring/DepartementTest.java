package tn.esprit.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.DepartementServiceImpl;
import tn.esprit.spring.services.EntrepriseServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {

    @Autowired
    private DepartementServiceImpl deptServiceImpl;
    @Autowired
    private DepartementRepository deptRepository;
    private final static Logger l = LogManager.getLogger(DepartementTest.class);

    public DepartementTest(){
        super();
    }

    @Test
    public  void ajouterDepartement() {
        Departement departement = new Departement();
        departement.setId(2);
        departement.setName("aaaa");
        Assertions.assertEquals(2, departement.getId());
        deptServiceImpl.ajouterDepartement(departement);
        l.info("Le departement est ajouté");
    }

    @Test


    @Test
    public void getDepartementById() {
        Departement Departement= deptServiceImpl.getDepartementById(4);
        assertThat(Departement.getId()).isEqualTo(4);
        l.info("Le departement est" +deptServiceImpl.getDepartementById(4));

    }

    @Test
    public void deleteDepartementById() {
        deptServiceImpl.deleteDepartementById(2);
        l.info("Le departement est supprimé");
    }

    @Test
    public void deleteAllDepartement(){
        deptServiceImpl.deleteAllDepartement();
        Assert.assertEquals("[]", deptRepository.findAll().toString());
        l.info("Tous les departements sont supprimés");
    }
}
