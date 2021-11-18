package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.exceptions.ResourceNotFoundException;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

import java.util.Date;
import java.util.List;

@Service
public class TimesheetServiceImpl implements ITimesheetService {


    @Autowired
    MissionRepository missionRepository;
    @Autowired
    DepartementRepository deptRepoistory;
    @Autowired
    TimesheetRepository timesheetRepository;
    @Autowired
    EmployeRepository employeRepository;

    private final Logger l = LogManager.getLogger(TimesheetServiceImpl.class);


    public int ajouterMission(Mission mission) {
        missionRepository.save(mission);
        return mission.getId();
    }

    public void affecterMissionADepartement(int missionId, int depId) {
        var mission = missionRepository.findById(missionId).orElseThrow(() -> new ResourceNotFoundException("mission not found with this id : " + missionId));
        var dep = deptRepoistory.findById(depId).orElseThrow(() -> new ResourceNotFoundException("departement not found with this id:" + depId));
        mission.setDepartement(dep);
        missionRepository.save(mission);

    }

    public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
        var timesheetPK = new TimesheetPK();
        timesheetPK.setDateDebut(dateDebut);
        timesheetPK.setDateFin(dateFin);
        timesheetPK.setIdEmploye(employeId);
        timesheetPK.setIdMission(missionId);

        var timesheet = new Timesheet();
        timesheet.setTimesheetPK(timesheetPK);
        timesheet.setValide(false); //par defaut non valide
        timesheetRepository.save(timesheet);

    }


    public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
        var validateur = employeRepository.findById(validateurId).orElseThrow(() -> new ResourceNotFoundException("employe not found with this id" + validateurId));
        var mission = missionRepository.findById(missionId).orElseThrow(() -> new ResourceNotFoundException("mission not found with this id: " + missionId));
        //verifier s'il est un chef de departement (interet des enum)
        if (!validateur.getRole().equals(Role.CHEF_DEPARTEMENT)) {
            l.info("l'employe doit etre chef de departement pour valider une feuille de temps !");
            return;
        }
        //verifier s'il est le chef de departement de la mission en question
        var chefDeLaMission = false;
        for (Departement dep : validateur.getDepartements()) {
            if (dep.getId() == mission.getDepartement().getId()) {
                chefDeLaMission = true;
                break;
            }
        }
        if (!chefDeLaMission) {
            l.info("l'employe doit etre chef de departement de la mission en question");
            return;
        }
//
        var timesheetPK = new TimesheetPK(missionId, employeId, dateDebut, dateFin);
        var timesheet = timesheetRepository.findBytimesheetPK(timesheetPK);
        timesheet.setValide(true);

        //Comment Lire une date de la base de données

    }


    public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
        return timesheetRepository.findAllMissionByEmployeJPQL(employeId);
    }


    public List<Employe> getAllEmployeByMission(int missionId) {
        return timesheetRepository.getAllEmployeByMission(missionId);
    }

}
