package Project.controller;

import Project.dao.LoginDAO;
import Project.dao.RegistDAO;
import Project.service.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping("/loginjsp")
    public String loginjsp(){
        return "Login";
    }
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map){
        System.out.println("controller load");
        boolean s=loginDAO.Login(username, password);
        map.put("error","verify false");
        if(s){
            return "yes";
        }else {
            return "redirect:/loginjsp";
        }
    }
    @RequestMapping("registjsp")
    public String registjsp(){
        return "Regist";
    }
    @RequestMapping("/regist")
    public String regist(@RequestParam("new_name") String username,@RequestParam("new_password") String password,
                         @RequestParam("password") String repassword,@RequestParam("email") String email,
                         Map<String,Object> map){
        if (repassword.equals(password)){
            map.put("rusername",username);
            map.put("rpassword",password);
            map.put("remail",email);
            code=demo.email(email);
            System.out.println(code);
            return "Code";
        }else{
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
}
