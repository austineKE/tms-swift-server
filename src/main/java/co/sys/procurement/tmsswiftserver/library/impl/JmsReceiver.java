package co.sys.procurement.tmsswiftserver.library.impl;

import co.sys.procurement.tmsswiftserver.dto.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

public class JmsReceiver {
    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }
}
