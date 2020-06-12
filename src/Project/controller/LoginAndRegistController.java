package Project.controller;

import Project.dao.LoginDAO;
import Project.dao.RegistDAO;
import Project.dao.UserManageDAO;
import Project.pojo.User;
import Project.service.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    @Autowired
    private UserManageDAO userManageDAO;
    /*------------------登录，注册，用户or管理员---------------------------*/
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map){
        System.out.println("controller load");
        boolean s=loginDAO.Login(username, password);
        if(s){
            String temp=null;
            String identify=loginDAO.Identify(username);
            User user=loginDAO.Select(username);
            map.put("user",user);
            if (identify.equals("stu")){
                temp="index";
            }else {
                temp="inform";
            }
            return temp;
        }else {
            map.put("error","verify false");
            return "Login";
        }
    }
    @RequestMapping("loginjsp")
    public String loginjsp(){
        return "Login";
    }
    @RequestMapping("/registjsp")
    public String registjsp(){
        return "Regist";
    }
    /*--------------注册用户验证----------------------*/
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
    /*-------修改密码后返回--------------*/
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
    public String modify(@PathVariable("user.username") String username,Map<String,Object> map){
        System.out.println("controller load.....");
        map.put("username",username);
        return "modify";
    }
    @RequestMapping(value = "/modifyform/{username}")
    public String modifyform(@PathVariable("username") String username,
                             @RequestParam("oldpassword") String Opassword,
                             @RequestParam("newpassword") String Npassword,
                             Map<String,Object> map){
        System.out.println("modifycontroller load...");
        Integer s=loginDAO.Updatepassword(username, Opassword, Npassword);
        if(s==1){
            return "redirect:/viewinform/{username}";
        }else{
            map.put("error","密码验证错误");
            return "modify";
        }

    }
    /*--------用户编辑个人资料--------------*/
    @RequestMapping("/message/{user.username}")
    public String usermessageedit(@PathVariable("user.username") String username,Map<String,Object> map){
        map.put("username",username);
        return "user_edit";
    }
    @RequestMapping(value = "/usermessage/{username}",produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    public String messageupdate(@PathVariable("username") String username,
                                @RequestParam("major") String major,
                                @RequestParam("stuID") Integer stuID,
                                @RequestParam("gender") String gender,
                                @RequestParam("stuclass") String stuclass,
                                Map<String,Object> map){
        User user=registDAO.UserMessage(username,major,stuID,gender,stuclass);
        map.put("user",user);
        return "index";
    }
    /*----------管理员进入用户管理界面------------*/
    @RequestMapping("/user_manager/{user.username}")
    public String findusers(@PathVariable("user.username") String username, Map<String,Object> map){
        System.out.println("finduserscontroller....");
        List<User> users=userManageDAO.findstu();
        System.out.println(users);
        map.put("username",username);
        map.put("users",users);
        return "user_manager";
    }
}
