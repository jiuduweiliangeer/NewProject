package Project.controller;

import Project.dao.LoginDAO;
import Project.dao.RegistDAO;
import Project.pojo.User;
import Project.service.Demo;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class LoginAndRegistController {
    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private RegistDAO registDAO;
    @Autowired
    private Demo demo;
    private String code;
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map){
        System.out.println("controller load");
        boolean s=loginDAO.Login(username, password);
        if(s){
            User user=loginDAO.Select(username);
            map.put("user",user);
            return "index";
        }else {
            map.put("error","verify false");
            return "Login";
        }
    }
    @RequestMapping("/registjsp")
    public String registjsp(){
        return "Regist";
    }
    @RequestMapping("/regist")
    public String regist(@Valid User user, BindingResult bindingResult,
                         @RequestParam("new_name") String username, @RequestParam("new_password") String password,
                         @RequestParam("password") String repassword, @RequestParam("email") String email,
                         Map<String,Object> map){
        if (repassword.equals(password)&&bindingResult.getErrorCount()<=0){
            map.put("rusername",username);
            map.put("rpassword",password);
            map.put("remail",email);
            code=demo.email(email);
            System.out.println(code);
            return "Code";
        }else{
            map.put("user",user);
            return "redirect:/registjsp";
        }
    }
    @RequestMapping(value = "/code/{rusername}/{rpassword}/{remail}")
    public String code(@PathVariable(value = "rusername",required = false) String username1,
                       @PathVariable("rpassword") String password1,
                       @PathVariable("remail") String email1,
                       @RequestParam("emailcode") String emailcode1){
        if (emailcode1.equals(code)){
            registDAO.Regist(username1, password1, email1+".com");
            return "redirect:/loginjsp";
        }else{
            return "redirect:/registjsp";
        }
    }
    @RequestMapping(value = "/viewinform/{username}")
    public String infrom(@PathVariable(value = "username")  String username,Map<String,Object> map){
            User user=loginDAO.Select(username);
            map.put("user",user);
            return "index";
    }
    @RequestMapping(value = "/viewmore/{user.username}")
    public String infrom1(@PathVariable(value = "user.username")  String username,Map<String,Object> map){
        User user=loginDAO.Select(username);
        map.put("user",user);
        return "inform";
    }
    @RequestMapping(value = "/demothis/{user.username}")
    public String modify(@PathVariable("user.username") String username,Map<Object,String> map){
        System.out.println("controller load.....");
        map.put("username",username);
        return "modify";
    }
    @RequestMapping(value = "/modifyform/{username}")
    public String modifyform(@PathVariable("username") String username,
                             @RequestParam("oldpassword") String Opassword,
                             @RequestParam("newpassword") String Npassword,
                             Map<Object,String> map){
        System.out.println("modifycontroller load...");
        Integer s=loginDAO.Updatepassword(username, Opassword, Npassword);
        if(s==1){
            return "redirect:/viewinform/{username}";
        }else{
            map.put("error","密码验证错误");
            return "modify";
        }

    }

}
