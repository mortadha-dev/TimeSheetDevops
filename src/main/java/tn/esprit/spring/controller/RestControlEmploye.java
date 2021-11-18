package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

import java.util.Date;
import java.util.List;


@RestController
public class RestControlEmploye {

    @Autowired
    IEmployeService iemployeservice;
    @Autowired
    IEntrepriseService ientrepriseservice;
    @Autowired
    ITimesheetService itimesheetservice;

    @PostMapping("/ajouterEmployer")
    @ResponseBody
    public EmployeDTO ajouterEmploye(@RequestBody EmployeDTO employeDTO) {
        var employe = new Employe();
        employe.setNom(employeDTO.getNomDTO());
        employe.setPrenom(employeDTO.getPrenomDTO());
        employe.setEmail(employeDTO.getEmailDTO());
        employe.setActif(true);
        employe.setRole(employeDTO.getRoleDTO());
        iemployeservice.ajouterEmploye(employe);
        return employeDTO;
    }

    @PutMapping(value = "/modifyEmail/{id}/{newemail}")
    @ResponseBody
    public void mettreAjourEmailByEmployeId(@PathVariable("newemail") String email, @PathVariable("id") int employeId) {
        iemployeservice.mettreAjourEmailByEmployeId(email, employeId);

    }

    // http://localhost:8081/SpringMVC/servlet/affecterEmployeADepartement/1/1
    @PutMapping(value = "/affecterEmployeADepartement/{idemp}/{iddept}")
    public void affecterEmployeADepartement(@PathVariable("idemp") int employeId, @PathVariable("iddept") int depId) {
        iemployeservice.affecterEmployeADepartement(employeId, depId);

    }

    // http://localhost:8081/SpringMVC/servlet/desaffecterEmployeDuDepartement/1/1
    @PutMapping(value = "/desaffecterEmployeDuDepartement/{idemp}/{iddept}")
    public void desaffecterEmployeDuDepartement(@PathVariable("idemp") int employeId, @PathVariable("iddept") int depId) {
        iemployeservice.desaffecterEmployeDuDepartement(employeId, depId);
    }

    // http://localhost:8081/SpringMVC/servlet/ajouterContrat

    @PostMapping("/ajouterContrat")
    @ResponseBody
    public int ajouterContrat(@RequestBody ContratDTO contratDTO) {
        var contrat = new Contrat();
        contrat.setDateDebut(contratDTO.getDateDebutDTO());
        contrat.setTypeContrat(contratDTO.getTypeContratDTO());
        contrat.setSalaire(contratDTO.getSalaireDTO());
        iemployeservice.ajouterContrat(contrat);
        return contrat.getReference();
    }

    // http://localhost:8081/SpringMVC/servlet/affecterContratAEmploye/6/1
    @PutMapping(value = "/affecterContratAEmploye/{idcontrat}/{idemp}")
    public void affecterContratAEmploye(@PathVariable("idcontrat") int contratId, @PathVariable("idemp") int employeId) {
        iemployeservice.affecterContratAEmploye(contratId, employeId);
    }


    // URL : http://localhost:8081/SpringMVC/servlet/getEmployePrenomById/2
    @GetMapping(value = "getEmployePrenomById/{idemp}")
    @ResponseBody
    public String getEmployePrenomById(@PathVariable("idemp") int employeId) {
        return iemployeservice.getEmployePrenomById(employeId);
    }

    // URL : http://localhost:8081/SpringMVC/servlet/deleteEmployeById/1
    @DeleteMapping("/deleteEmployeById/{idemp}")
    @ResponseBody
    public void deleteEmployeById(@PathVariable("idemp") int employeId) {
        iemployeservice.deleteEmployeById(employeId);

    }

    // URL : http://localhost:8081/SpringMVC/servlet/deleteContratById/2
    @DeleteMapping("/deleteContratById/{idcontrat}")
    @ResponseBody
    public void deleteContratById(@PathVariable("idcontrat") int contratId) {
        iemployeservice.deleteContratById(contratId);
    }


    // URL : http://localhost:8081/SpringMVC/servlet/getNombreEmployeJPQL
    @GetMapping(value = "getNombreEmployeJPQL")
    @ResponseBody
    public int getNombreEmployeJPQL() {

        return iemployeservice.getNombreEmployeJPQL();
    }

    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeNamesJPQL
    @GetMapping(value = "getAllEmployeNamesJPQL")
    @ResponseBody
    public List<String> getAllEmployeNamesJPQL() {

        return iemployeservice.getAllEmployeNamesJPQL();
    }

    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeByEntreprise/1
    @GetMapping(value = "getAllEmployeByEntreprise/{identreprise}")
    @ResponseBody
    public List<Employe> getAllEmployeByEntreprise(@PathVariable("identreprise") int identreprise) {
        var entreprise = ientrepriseservice.getEntrepriseById(identreprise);
        return iemployeservice.getAllEmployeByEntreprise(entreprise);
    }

    @GetMapping(value = "getAllEmployeByDepartement/{iddepartement}")
    @ResponseBody
    public int getAllEmployeByDepartement(@PathVariable("iddepartement") int iddepartement) {
        return iemployeservice.getAllEmployeByDepartement(iddepartement);
    }

    // Modifier email : http://localhost:8081/SpringMVC/servlet/mettreAjourEmailByEmployeIdJPQL/2/newemail
    @PutMapping(value = "/mettreAjourEmailByEmployeIdJPQL/{id}/{newemail}")
    @ResponseBody
    public void mettreAjourEmailByEmployeIdJPQL(@PathVariable("newemail") String email, @PathVariable("id") int employeId) {
        iemployeservice.mettreAjourEmailByEmployeIdJPQL(email, employeId);

    }

    // URL : http://localhost:8081/SpringMVC/servlet/deleteAllContratJPQL
    @DeleteMapping("/deleteAllContratJPQL")
    @ResponseBody
    public void deleteAllContratJPQL() {
        iemployeservice.deleteAllContratJPQL();

    }

    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireByEmployeIdJPQL/2
    @GetMapping(value = "getSalaireByEmployeIdJPQL/{idemp}")
    @ResponseBody
    public float getSalaireByEmployeIdJPQL(@PathVariable("idemp") int employeId) {
        return iemployeservice.getSalaireByEmployeIdJPQL(employeId);
    }

    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireMoyenByDepartementId/2
    @GetMapping(value = "getSalaireMoyenByDepartementId/{iddept}")
    @ResponseBody
    public Double getSalaireMoyenByDepartementId(@PathVariable("iddept") int departementId) {
        return iemployeservice.getSalaireMoyenByDepartementId(departementId);
    }

    // URL : http://localhost:8081/SpringMVC/servlet/getTimesheetsByMissionAndDate
    public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
                                                         Date dateFin) {
        return iemployeservice.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
    }


    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployes
    @GetMapping(value = "/getAllEmployes")
    @ResponseBody
    public List<Employe> getAllEmployes() {

        return iemployeservice.getAllEmployes();
    }


}