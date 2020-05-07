package Project.service;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;
@Service
public class Send {
    /**
     *
     * @param user 用户名
     * @param password 密码（"并不是登录密码，是邮箱生成的授权码"）
     * @param host
     * @param from 发件人邮箱地址
     * @param to 收件人邮箱地址
     * @param subject 邮件主题
     * @param context 邮件内容
     * @return
     * @throws Exception
     */
    public String sendMail(String user,String password,String host
    ,String from,String to,String subject,String context)throws Exception{
        if(to !=null){
            Properties properties=System.getProperties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.auth", "true");
            Mail auth=new Mail();
            Mail.Username=user;
            Mail.Password=password;
            Session session=Session.getInstance(properties,auth);
            session.setDebug(true);
            try{
                MimeMessage message=new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                if(!to.trim().equals("") ){
                    message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to.trim())));
                }
                message.setSubject(subject);
                MimeBodyPart mbp1=new MimeBodyPart();//邮件正文
                mbp1.setContent(context,"text/html;charset=utf-8");
                Multipart mp=new MimeMultipart();//整个邮件 正文加附件
                mp.addBodyPart(mbp1);
                message.setContent(mp);
                message.setSentDate(new Date());
                message.saveChanges();
                Transport trans=session.getTransport("smtp");
                trans.send(message);
                System.out.println(message.toString());
            }catch (Exception e){
                e.printStackTrace();
                return "failure";
            }
            return "success";
        }else {
            return "failure";
        }
    }
}
