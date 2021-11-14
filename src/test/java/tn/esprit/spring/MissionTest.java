package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.services.EmployeServiceImpl;


@SpringBootTest
public class MissionTest {

    @Autowired
    MissionServiceImpl es;
    @Autowired
    MissionRepository missionRepository;
    @Autowired
    EmployeRepository emprepo;

    @Autowired
    EmployeServiceImpl employeService;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    MissionServiceImpl missionService;

    private static final Logger l = LogManager.getLogger(MissionTest.class);


    @Test

    public void getAllMission() {

        l.info("Mission est : " + es.getAllMission());
    }


    @Test
    public void testCreateMission() {

        int a = es.ajouterMission(new Mission("mission1", "description1"));
        Assertions.assertNotNull(a);
        l.info("idMission: " + a);

    }


    @Test
    public void findAllMissionByEmployeJPQL() {
        var employe = new Employe("aicha", "salah", "aicha@esprit.tn", true, Role.CHEF_DEPARTEMENT);
        employeService.ajouterEmploye(employe);
        es.findAllMissionByEmployeJPQL(employe.getId());
    }

    @Test
    public void getAllEmployeByMission() {
        int missionId = es.ajouterMission(new Mission("mission3", "description3"));
        missionService.getAllEmployeByMission(missionId);

    }


    @Test
    public void Deletemission() {
        int missionId = es.ajouterMission(new Mission("mission3", "description3"));
        es.deleteMissionById(missionId);
        l.info("Mission est supprimé");
    }

    @Test
    public void affecterMissionADepartement() {
        int missionId = es.ajouterMission(new Mission("mission1", "description1"));
        var departement = new Departement("Géologie");
        departementRepository.save(departement);
        int depId = departement.getId();
        es.affecterMissionADepartement(missionId, depId);
        l.info("La mission qui a l'id: " + missionId + " est affecté au département avec l'id : " + depId);
    }

}
