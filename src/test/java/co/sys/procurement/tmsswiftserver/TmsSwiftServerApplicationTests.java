package co.sys.procurement.tmsswiftserver;

import co.sys.procurement.tmsswiftserver.model.Project;
import co.sys.procurement.tmsswiftserver.model.User;
import co.sys.procurement.tmsswiftserver.service.QueryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert.*;

@SpringBootTest
class TmsSwiftServerApplicationTests {

	@Autowired
	private QueryService queryService;

	@Test
	void contextLoads() {
	}

	@Test
	void testUserDetails(){
		User user=new User();
        user.setId(8);
		user.setFirstName("Kijana");
		user.setLastName("Wamalwa");
		user.setUserName("kwamalw");
		user.setEmail("kijana.wamalwa@gmail.com");
		user.setPassword("tms_23456");
		int val=queryService.getUserJdbcTemplate().update("INSERT into tms_userdetail.dbo.[user] values (?,?,?,?,?,?)", user.getId(), user.getFirstName(),user.getLastName(),user.getUserName(), user.getEmail(), user.getPassword());
		Assertions.assertEquals(1, val);
	}

	@Test
	void testProjectDetails(){
		Project project=new Project();
        project.setId(3);
		project.setLocation("thika");
		project.setNameOfProject("Information Technology ");
		project.setProjectCode("tnx-245");
		project.setTimeline("05/05/2024");
		queryService.getProcurementJdbcTemplate().update("INSERT INTO tms_procurement.dbo.[project] values(?,?,?,?,?)", project.getId(), project.getNameOfProject(), project.getProjectCode(),project.getLocation(), project.getTimeline());

	}

}