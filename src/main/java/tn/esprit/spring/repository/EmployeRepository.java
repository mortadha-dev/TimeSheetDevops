package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;


@Repository
public interface EmployeRepository extends CrudRepository<Employe, Integer>  {


    @Query(value = "SELECT count(*) FROM Employe", nativeQuery = true)
    int countemp();

    @Query("SELECT nom FROM Employe")
    List<String> employeNames();


    @Query("Select "
            + "DISTINCT emp from Employe emp "
            + "join emp.departements dps "
            + "join dps.entreprise entrep "
            + "where entrep=:entreprise")
    List<Employe> getAllEmployeByEntreprisec(@Param("entreprise") Entreprise entreprise);

    @Query( value = "SELECT COUNT(employes_id) FROM departement_employes WHERE departements_id=:departement",nativeQuery = true)
    int getAllEmployeByDepartement(@Param("departement") int departement);

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