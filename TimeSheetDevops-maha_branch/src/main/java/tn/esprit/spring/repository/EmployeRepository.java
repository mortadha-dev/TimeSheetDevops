package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;


public interface EmployeRepository extends CrudRepository<Employe, Integer>  {


    @Query("SELECT count(*) FROM Employe")
    int countemp();

    @Query("SELECT nom FROM Employe")
    List<String> employeNames();


    @Query("Select "
            + "DISTINCT emp from Employe emp "
            + "join emp.departements dps "
            + "join dps.entreprise entrep "
            + "where entrep=:entreprise")
    List<Employe> getAllEmployeByEntreprisec(@Param("entreprise") Entreprise entreprise);

    @Modifying
    @Transactional
    @Query("UPDATE Employe e SET e.email=:email1 where e.id=:employeId")
    void mettreAjourEmailByEmployeIdJPQL(@Param("email1")String email, @Param("employeId")int employeId);


    @Modifying
    @Transactional
    @Query("DELETE from Contrat")
    void deleteAllContratJPQL();

    @Query("select c.salaire from Contrat c join c.employe e where e.id=:employeId")
    float getSalaireByEmployeIdJPQL(@Param("employeId")int employeId);


    @Query("Select "
            + "DISTINCT AVG(cont.salaire) from Contrat cont "
            + "join cont.employe emp "
            + "join emp.departements deps "
            + "where deps.id=:depId")
    Double getSalaireMoyenByDepartementId(@Param("depId")int departementId);




}