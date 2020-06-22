package Project.controller;

import Project.dao.*;
import Project.pojo.*;
import Project.service.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private SeatManageDAO seatManageDAO;
    @Autowired
    private SeatSelectDAO seatSelectDAO;
    @Autowired
    private HistoryDAO historyDAO;
    @Autowired
    private PublishDAO publishDAO;
    @Autowired
    private DestineDAO destineDAO;
    /*------------------登录，注册，用户or管理员---------------------------*/
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map){
        System.out.println("controller load");

        boolean s=loginDAO.Login(username, password);
        boolean u=loginDAO.judge_use(username);
        if(s&&u){
            int judge=destineDAO.judge_destine_time(username);
            if (judge==0){
                destineDAO.destine_delete(username);
            }
            String temp=null;
            String identify=loginDAO.Identify(username);
            User user=loginDAO.Select(username);
            map.put("user",user);
            if (identify.equals("stu")){
                List<Publish> publishes=publishDAO.findpublish();
                map.put("publishes",publishes);
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
            String identify=loginDAO.Identify(username);
            if (identify.equals("stu")){
                User user=loginDAO.Select(username);
                map.put("user",user);
                List<Publish> publishes=publishDAO.findpublish();
                map.put("publishes",publishes);
                return "index";
            }else{
                return "redirect:/viewmore/{username}";
            }
    }
    @RequestMapping(value = "/viewmore/{username}")
    public String infrom1(@PathVariable(value = "username")  String username,Map<String,Object> map){
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
            String identify=loginDAO.Identify(username);
            if(identify.equals("stu")){
                return "redirect:/viewinform/{username}";
            }else{
                return "redirect:/viewmore/{username}";
            }

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
                                @RequestParam("name") String name,
                                Map<String,Object> map){
        User user=registDAO.UserMessage(username,major,stuID,gender,stuclass,name);
        map.put("user",user);
        List<Publish> publishes=publishDAO.findpublish();
        map.put("publishes",publishes);
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
    /*---------管理用户界面查询----------------*/
    @RequestMapping("/user_manager_select/{username}")
    public String user_manager_select(@PathVariable("username") String username,
                                      @RequestParam("state") String state,
                                      @RequestParam("susername") String susername,
                                      @RequestParam("email") String email,
                                      Map<String,Object> map){
        List<User> users=userManageDAO.selectfind(state,susername,email);
        System.out.println(users);
        map.put("username",username);
        map.put("users",users);
        return "user_manager";
    }
    /*---------管理用户状态---------------*/
    @RequestMapping("/openuser/{username}/{user.username}")
    public String openuser(@PathVariable("username") String username,
                           @PathVariable("user.username") String susername,
                           Map<String,Object> map){
        List<User> users=userManageDAO.openuser(susername);
        map.put("username",username);
        map.put("users",users);
        return "user_manager";
    }
    @RequestMapping("/closeuser/{username}/{user.username}")
    public String closeuser(@PathVariable("username") String username,
                           @PathVariable("user.username") String susername,
                           Map<String,Object> map){
        List<User> users=userManageDAO.closeuser(susername);
        map.put("username",username);
        map.put("users",users);
        return "user_manager";
    }
    /*-----------进入座位管理界面-------------*/
    @RequestMapping("/seat_manager/{user.username}")
    public String findseat(@PathVariable("user.username") String username, Map<String,Object> map){
        System.out.println("findseatcontroller....");
        int temp=destineDAO.judge_destine_time(username);
        if (temp==0){
            destineDAO.destine_delete(username);
        }
        List<Seat> seats=seatManageDAO.findset();
        System.out.println(seats);
        map.put("username",username);
        map.put("seats",seats);
        return "seat_manager";
    }
    /*----------进入添加座位界面-------------*/
    @RequestMapping("/addseat/{username}")
    public String addseatjsp(@PathVariable("username") String username,
                             Map<String,Object> map){
        map.put("username",username);
        return "AddSeat";
    }
    /*---------添加座位后返回管理座位界面----------*/
    @RequestMapping("/seatadd/{username}")
    public String seatjsp(@PathVariable("username") String username,
                          @RequestParam("location") String location,
                          Map<String,Object> map) throws SQLException {
        int temp=seatManageDAO.addseat(location);
        if(temp==1){
            List<Seat> seats=seatManageDAO.findset();
            map.put("username",username);
            map.put("seats",seats);
            return "seat_manager";
        }else {
            map.put("username",username);
            map.put("error","该座位已存在");
            return "AddSeat";
        }
    }
    /*-------未添加座位返回座位管理界面-------------*/
    @RequestMapping("/seatjsp/{username}")
    public String seatjspno(@PathVariable("username") String username,
                            Map<String,Object> map){
        List<Seat> seats=seatManageDAO.findset();
        map.put("username",username);
        map.put("seats",seats);
        return "seat_manager";
    }
    /*--------------------查询座位-----------------------*/
    @RequestMapping("/seat_manager_select/{username}")
    public String seat_manager_select(@PathVariable("username") String username,
                                      @RequestParam("state") String state,
                                      @RequestParam("location") String location,
                                      Map<String,Object> map){
        List<Seat> seats=seatManageDAO.select_seat(state,location);
        map.put("username",username);
        map.put("seats",seats);
        System.out.println(state);
        return "seat_manager";
    }
    @RequestMapping("/maintain/{username}/{seat.location}")
    public String maintain_seat(@PathVariable("username") String username,
                                @PathVariable("seat.location") String location,
                                Map<String,Object> map){
        List<Seat> seats=seatManageDAO.maintain_seat(location);
        map.put("username",username);
        map.put("seats",seats);
        return "seat_manager";
    }
    @RequestMapping("/delete/{username}/{seat.location}")
    public String delete_seat(@PathVariable("username") String username,
                              @PathVariable("seat.location") String location,
                              Map<String,Object> map){
        List<Seat> seats=seatManageDAO.delete_seat(location);
        map.put("username",username);
        map.put("seats",seats);
        return "seat_manager";
    }
    /*--------------------------------------------------------------------------------------*/
    /*------------------学生进入座位选择界面-----------------------------*/
    @RequestMapping("/seat_select/{user.username}")
    public String seat_selectjsp(@PathVariable("user.username") String username,
                                 Map<String,Object> map){
        int temp=destineDAO.judge_destine_time(username);
        if (temp==0){
            destineDAO.destine_delete(username);
        }
        List<Seat> seats=seatSelectDAO.findselect_seat();
        map.put("username",username);
        map.put("seats",seats);
        return "seat_select";
    }
    /*-----------------学生报告故障处理-------------------------------*/
    @RequestMapping("/false/{username}/{location}")
    public String seat_false_stu(@PathVariable("username") String username,
                                 @PathVariable("location") String location,
                                 Map<String,Object> map){
        List<Seat> seats=seatSelectDAO.false_seat(location,username);
        map.put("username",username);
        map.put("seats",seats);
        return "seat_select";
    }
    /*----------------学生查询座位------------------------------*/
    @RequestMapping("/select_seat_stu/{username}")
    public String select_seat_stu(@PathVariable("username") String username,
                                 @RequestParam("useruse") String useruse,
                                 @RequestParam("location") String location,
                                 Map<String,Object> map){
        List<Seat> seats=seatSelectDAO.select_seat_stu(useruse,location);
        map.put("username",username);
        map.put("seats",seats);
        return "seat_select";
    }
    /*--------------------学生预定座位-------------------------*/
    @RequestMapping("/destine/{username}/{seat.location}")
    public String entrace_destine(@PathVariable("username") String username,
                                  @PathVariable("seat.location") String location,
                                  Map<String,Object> map){
        int temp=seatSelectDAO.judge(location);
        String s=null;
        if (temp==1){
            seatSelectDAO.insert_time(username,location);
            List<Seat> seats=seatSelectDAO.findselect_seat();
            map.put("username",username);
            map.put("seats",seats);
            return "seat_select";
        }else if(temp==0){
            List<Seat> seats=seatSelectDAO.findselect_seat();
            map.put("username",username);
            map.put("seats",seats);
            map.put("location",location);
            map.put("error","false or occupy");
            s="seat_select";
        }
        return s;
    }
    /*-----------------------------------------------------------*/
    /*-----------------学生进入相应的历史记录界面--------------------*/
    @RequestMapping("/stu_history/{user.username}")
    public String stu_history(@PathVariable("user.username") String username,
                              Map<String,Object> map){
        int temp=destineDAO.judge_destine_time(username);
        if (temp==0){
            destineDAO.destine_delete(username);
        }
        List<History> histories=historyDAO.findhistory(username);
        map.put("username",username);
        map.put("histories",histories);
        return "historical_record";
    }
    /*-----------------------------------------------------------*/
    /*---------------------学生进入公告查询界面--------------------------*/
    @RequestMapping("/publish/{user.username}")
    public String publish(@PathVariable("user.username") String username,
                          Map<String,Object> map){
        List<Publish> publishes=publishDAO.findpublish();
        map.put("username",username);
        map.put("publishes",publishes);
        return "publish";
    }
    /*-------------------学生进入预约记录界面----------------------*/
    @RequestMapping("/destine_jsp/{user.username}")
    public String destine_jsp(@PathVariable("user.username") String username,
                              Map<String,Object> map){
        int temp=destineDAO.judge_destine_time(username);
        if (temp==0){
            destineDAO.destine_delete(username);
        }
        Dastine dastine=destineDAO.select(username);
        map.put("username",username);
        map.put("dastine",dastine);
        return "destine";
    }
    /*-----------------修改预约状态-------------------------*/
    @RequestMapping("/cancel/{username}/{location}")
    public String destine_cancel(@PathVariable("username") String username,
                                 @PathVariable("location") String location,
                                 Map<String,Object> map){
        destineDAO.destine_cancel(username,location);
        Dastine dastine=destineDAO.select(username);
        map.put("username",username);
        map.put("dastine",dastine);
        return "destine";
    }
    @RequestMapping("/confirm/{username}/{dastine.location}")
    public String destine_comfirm(@PathVariable("username") String username,
                                 @PathVariable("dastine.location") String location,
                                 Map<String,Object> map){
        destineDAO.destine_confirm(username,location);
        Dastine dastine=destineDAO.select(username);
        map.put("username",username);
        map.put("dastine",dastine);
        return "destine";
    }
    @RequestMapping("/end/{username}/{dastine.location}")
    public String destine_end(@PathVariable("username") String username,
                                  @PathVariable("dastine.location") String location,
                                  Map<String,Object> map){
        destineDAO.destine_end(username,location);
        Dastine dastine=destineDAO.select(username);
        map.put("username",username);
        map.put("dastine",dastine);
        return "destine";
    }
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin)

    {

        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

        CustomDateEditor cust =new CustomDateEditor (sdf,true);

        bin.registerCustomEditor(Date.class,cust);

    }
}
