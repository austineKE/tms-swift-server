package co.sys.procurement.tmsswiftserver;

import co.sys.procurement.tmsswiftserver.service.impl.ProjectImplService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ImportResource("file:./conf/context.xml")
@EntityScan(basePackages = "co.sys.procurement.tmsswiftserver.model.*")
@EnableJpaRepositories(basePackages = "co.sys.procurement.tmsswiftserver.repository", entityManagerFactoryRef = "entityManagerFactory")
public class TmsSwiftServerApplication{
	private Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	private static ConfigurableApplicationContext applicationContext;
	@Autowired
	private ProjectImplService projectImplService;

	public static void main(String[] args) {
		applicationContext= SpringApplication.run(TmsSwiftServerApplication.class, args);

	}

}
