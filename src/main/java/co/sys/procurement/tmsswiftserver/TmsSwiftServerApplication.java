package co.sys.procurement.tmsswiftserver;

import co.sys.procurement.tmsswiftserver.dto.Email;
import co.sys.procurement.tmsswiftserver.library.impl.JmsReceiver;
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
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@ImportResource("file:./conf/context.xml")
@EntityScan(basePackages = "co.sys.procurement.tmsswiftserver.model.*")
@EnableJpaRepositories(basePackages = "co.sys.procurement.tmsswiftserver.repository", entityManagerFactoryRef = "entityManagerFactory")
@EnableJms
public class TmsSwiftServerApplication{
	private static Logger logger=LoggerFactory.getLogger(TmsSwiftServerApplication.class);
	private static ConfigurableApplicationContext applicationContext;
	@Autowired
	private ProjectImplService projectImplService;
	private JmsReceiver jmsReceiver;

	public static void main(String[] args) {
		applicationContext= SpringApplication.run(TmsSwiftServerApplication.class, args);
		JmsTemplate jmsTemplate= (JmsTemplate) applicationContext.getBean("myJmsTemplate");
		logger.info("Calling JmsTemplate.......");
//		jmsTemplate.convertAndSend("mailbox", new Email("austinewamalwa18@gmail.com", "Hello JMS"));
		jmsTemplate.convertAndSend("austinewamalwa18@gmail.com", "Hello JMS");
		jmsTemplate.convertAndSend("austinewamalwa18@gmail.com", "Welcome to activemq implementation");
		logger.info("Finished calling JmsTemplate.......");
	}

}
