package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


@SpringBootTest
class TimesheetApplicationTests {

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
	private final static Logger l = LogManager.getLogger(TimesheetApplicationTests.class);

	@Test
	void contextLoads() {

	}

	@Test
	void addMission(){
		Mission m1 = new Mission( "mission", "c ma mission");
		Assertions.assertNotNull(m1);
		timesheetService.ajouterMission(m1) ;
		l.info("mission added"+ timesheetService.ajouterMission(m1));
	}
	@Test
	void addDepartement(){
		Departement d1 = new Departement( "premier department");
		Assertions.assertNotNull(d1);
		departementRepository.save(d1);
		l.info("department added"+ departementRepository.save(d1));
	}

	@Test
	void addEmploye()  {
		Employe e1 = new Employe( "Mayssa", "Mayssa","maissa@gmail.com",true, Role.ADMINISTRATEUR);
		Assertions.assertNotNull(e1);
		employeRepository.save(e1);
		l.info("user added ");
	}
	@Test
	void addTimesheet() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-10-05");
		Date d1 = dateFormat.parse("2021-10-07");
		Employe e1 = new Employe( "Mayssa", "Mayssa","maissa@gmail.com",true, Role.ADMINISTRATEUR);
		Assertions.assertNotNull(e1);
		employeRepository.save(e1);
		l.info("user added ");
		Mission m1 = new Mission( "mission", "c ma mission");
		Assertions.assertNotNull(m1);
		timesheetService.ajouterMission(m1) ;
		l.info("mission added"+ timesheetService.ajouterMission(m1));
		timesheetService.ajouterTimesheet(m1.getId(),e1.getId(),d,d1);
		l.info("Timesheet added ");
	}




}



