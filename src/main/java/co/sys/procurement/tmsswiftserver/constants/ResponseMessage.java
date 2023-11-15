package co.sys.procurement.tmsswiftserver.constants;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ResponseMessage {
    private Logger logger= LoggerFactory.getLogger(ResponseMessage.class);
//    @Value("messageConfDir")
    private String configDir="./conf/tms/";

    public  Properties getResponseMessage(){
        try {
            Properties properties=new Properties();
            FileInputStream fis=new FileInputStream(configDir.concat("response_message.properties"));
            properties.load(fis);
            fis.close();
            return properties;
        }
        catch (IOException e){
            logger.error("Error while fetching message properties {}", e);
        }
        return null;
    }
}
