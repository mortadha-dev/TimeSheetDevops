package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;



public interface ITimesheetService {

	 int ajouterMission(Mission mission);
	 void affecterMissionADepartement(int missionId, int depId);
	 void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin);
	 void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId);
	 List<Mission> findAllMissionByEmployeJPQL(int employeId);
	 List<Employe> getAllEmployeByMission(int missionId);
}
