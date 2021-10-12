package tn.esprit.spring;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;

@SpringBootTest
class TimesheetApplicationTests {
	@Autowired
	private EmployeRepository employeRepository;
	@Test
	void contextLoads() {
	}
	@Test
	public void ajoutEmploye() {
		Employe employe = new Employe();
		employe.setNom("ahmed");
		employe.setPrenom("bouallagui");
		employe.setEmail("ahmed@esprit.tn");
		employe.setActif(true);
		employe.setRole(Role.CHEF_DEPARTEMENT);
		System.out.println(employe.getPrenom());
		Assertions.assertThat(employe.getNom()).isEqualTo("ahmed");
		employeRepository.save(employe);
		//  employeService.ajouterEmploye(employe);
	}
	@Test
	public void showCategories(){
		employeRepository.findAll();
	}

}
