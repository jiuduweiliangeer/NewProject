package Project.controller;

import Project.dao.LoginDAO;
import Project.dao.RegistDAO;
import Project.pojo.User;
import Project.service.Demo;
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
    @RequestMapping("/loginjsp")
    public String loginjsp(){
        return "Login";
    }
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map){
        System.out.println("controller load");
        boolean s=loginDAO.Login(username, password);
        if(s){
            map.put("username",username);
            return "yes";
        }else {
            map.put("error","verify false");
            return "redirect:/loginjsp";
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
            return "inform";
    }
    @RequestMapping(value = "/demothis/{username}")
    public String modify(@PathVariable("username") String username,Map<Object,String> map){
        System.out.println("controller load.....");
        map.put("username",username);
        return "modify";
    }
    @RequestMapping(value = "/modifyform/{username}")
    public String modifyform(@PathVariable("username") String username,@RequestParam("oldpassword") String Opassword,@RequestParam("newpassword") String Npassword){

        User user=loginDAO.Updatepassword(Opassword,username,Npassword);
        return "redirect:/viewinform/{username}";
    }
    @RequestMapping("/demojjj")
    public String returnthis(){
        return "redirect:/registjsp";
    }
}
