package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootTest
@RunWith(SpringRunner.class)
 class EntrepriseServiceImplTest {

	@Autowired
    private EntrepriseServiceImpl entrepriseService;
    private final static Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);

	 @Test
	    void DeleteEntreprise() {

	        entrepriseService.deleteEntrepriseById(1);
	        l.info("L'entreprise est supprimé");
	    }
	 @Test
	    void affecterDepartementAEntreprise() {
	        int entrepriseId = 1;
	        int departmentId = 1;
	        entrepriseService.affecterDepartementAEntreprise( departmentId , entrepriseId);
	        l.info("l'entreprise qui a l'id: " + entrepriseId + " est affecté au département avec l'id : " + departmentId);
	    }
	    @Test
	    void ajouterEntreprise() {

	        Assertions.assertSame(52,789);
	        l.info("l'entreprise est ajouté");
	    }
	    @Test
	     void getEntrepriseByIdA() {
	    var Entreprise= entrepriseService.getEntrepriseById(1);
	    assertThat(Entreprise.getId()).isEqualTo(1);
        l.info("l'entreprise est");

	    }
	    @Test
	    void getEntrepriseById() {
	        int entrepriseId = 1;
	        l.info("l'entreprise est : " + entrepriseService.getEntrepriseById(entrepriseId));

	    }
}
