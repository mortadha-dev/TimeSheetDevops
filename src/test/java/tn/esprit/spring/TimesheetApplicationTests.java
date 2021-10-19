package tn.esprit.spring;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.EmployeServiceImpl;


@SpringBootTest
class TimesheetApplicationTests {
    @Autowired
    private EmployeServiceImpl employeService;
    private final static Logger l = LogManager.getLogger(EmployeTest.class);
    @Autowired
    private ContratRepository contratRepository;
    @Test
    void contextLoads() {
        employeService.deleteAllContratJPQL();
        Assert.assertEquals("[]", contratRepository.findAll().toString());
        l.info("tous les contrats sont supprimés");

    }
}
