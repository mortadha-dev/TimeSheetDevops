
package tn.esprit.spring;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.TimesheetServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class TimesheetApplicationTests {
    @Autowired
    TimesheetServiceImpl timesheetService;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    EmployeRepository employeRepository;
    @Autowired
    MissionRepository missionRepository;
    @Autowired
    TimesheetRepository timesheetRepository;
    private final static Logger l = LogManager.getLogger(TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTests.class);

    @Test
    public void contextLoads() {

    }

    @Test
    public void ajouterMission(){
      Mission m1 = new Mission( "mission", "c ma mission");
      timesheetService.ajouterMission(m1) ;
        l.info("mission ajouté"+ timesheetService.ajouterMission(m1));
    }
    @Test
    public void ajouterDepartement(){
        Departement d1 = new Departement( "premier departement");
        departementRepository.save(d1);
        l.info("departement ajouté"+ departementRepository.save(d1));
    }
    @Test
    public void affecterMissiontoDepartement(){
        timesheetService.affecterMissionADepartement(1,1);
        l.info("departement ajouté au mission");
    }
    @Test
    public void ajouterEmploye()  {
        Employe e1 = new Employe( "Mayssa", "Mayssa","maissa@gmail.com",true, Role.ADMINISTRATEUR);
        employeRepository.save(e1);
        l.info("employe ajouté ");
    }
    @Test
    public void ajouterTimesheet() throws ParseException {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = dateFormat.parse("2021-10-05");
        Date d1 = dateFormat.parse("2021-10-07");
        timesheetService.ajouterTimesheet(1,1,d,d1);
    l.info("Timesheet ajouté ");
    }
    @Test
    public void valideTimesheet() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = dateFormat.parse("2021-10-05");
        Date d1 = dateFormat.parse("2021-10-07");

        timesheetService.validerTimesheet(1,1,d,d1,2);
    }

    @Test
    public void retrieveAllTimesheets(){
        ArrayList<Timesheet> timesheets = (ArrayList<Timesheet>) timesheetRepository.findAll();

      for (Timesheet valeur : timesheets) {
            l.info("timesheet"+ valeur);
        }
        }
    }



