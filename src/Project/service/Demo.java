package Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Demo {
    @Autowired
    private Send send;
    public String email(String to){
        String user="-------------（邮箱地址）";
        String password="----------------（STMP授权密码）";
        String host="smtp.qq.com";
        String from="64030931@qq.com";
        String subject="验证码";
        StringBuffer stringBuffer=new StringBuffer();
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        stringBuffer.append(result);
        try{
            String res=send.sendMail(user,password,host,from,to,subject,stringBuffer.toString());
            System.out.println(res);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
