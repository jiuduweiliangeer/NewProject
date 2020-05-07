package Project.service;

import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
@Service
public class Mail extends Authenticator{
    public static String Username="";
    public static String Password="";
    public  Mail(){

    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(Username,Password);
    }
}
