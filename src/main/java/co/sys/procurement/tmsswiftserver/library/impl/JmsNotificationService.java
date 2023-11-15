package co.sys.procurement.tmsswiftserver.library.impl;

import co.sys.procurement.tmsswiftserver.dto.Email;
import co.sys.procurement.tmsswiftserver.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
public class JmsNotificationService {
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    private static ConfigurableApplicationContext applicationContext;

    public ResponseDto sendNotification(String to, String body){
        try {
            ResponseDto responseDto=new ResponseDto();
            JmsTemplate jmsTemplate= (JmsTemplate) applicationContext.getBean("myJmsTemplate");
            jmsTemplate.convertAndSend("austinewamalwa18@gmail.com", "Hello JMS");
            return responseDto;
        }
        catch (Exception e){
            logger.info("Error occurred while sending notification {}", e);
        }

        return null;
    }

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
