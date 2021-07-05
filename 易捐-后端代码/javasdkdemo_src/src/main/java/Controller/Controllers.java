package Controller;

import Beans.Contribute;
import Beans.Projects;
import Beans.User;
import Dao.DonatorCountDao;
import Service.ContributeService;
import Service.DonatorCountService;
import Service.ProjectService;
import Service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping(path = "/dispatch",produces ="text/html;charset=utf-8")
public class Controllers {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private HttpServletRequest request;

    public HttpServletRequest getRequest() {
        return request;
    }

    @Autowired(required = false)
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    private ProjectService projectService;

    public ProjectService getProjectService() {
        return projectService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    private ContributeService contributeService;

    public ContributeService getContributeService() {
        return contributeService;
    }

    @Autowired
    public void setContributeService(ContributeService contributeService) {
        this.contributeService = contributeService;
    }

    private DonatorCountService donatorCountService;

    public DonatorCountService getDonatorCountService() {
        return donatorCountService;
    }

    @Autowired
    public void setDonatorCountDao(DonatorCountService donatorCountService) {
        this.donatorCountService = donatorCountService;
    }

    @ResponseBody
    @RequestMapping(path = "/login")
    public String login(User u){
        int id=userService.checkUser(u);
        if(id!=-1){
            HttpSession session=request.getSession();
            session.setAttribute("user_ID",u.getUser_ID());
            session.setAttribute("id",Integer.toString(id));
            return "success";
        }else {
            return "fail";
        }
    }

    @ResponseBody
    @RequestMapping(path = "/user")
    public String getUser(){
        HttpSession session=request.getSession();
        return (String) session.getAttribute("id");
    }

    @ResponseBody
    @RequestMapping(path = "/user_ID")
    public String getUser_ID(){
        HttpSession session=request.getSession();
        return (String) session.getAttribute("user_ID");
    }

    @ResponseBody
    @RequestMapping(path = "/project")
    public String project(Projects p){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(projectService.addProject(p)) {
            return "success";
        }else{
            return "fail";
        }
    }

    @ResponseBody
    @RequestMapping(path = "/projects")
    public String ReturnProjectJson(){
        List<Projects>lists=projectService.getProjects();
        return JSON.toJSONString(lists);
    }

    @ResponseBody
    @RequestMapping(path = "/projectsByUser")
    public String ReturnProjectJsonByUser(int user){
        List<Projects>lists=projectService.getProjects(user);
        return JSON.toJSONString(lists);
    }

    @ResponseBody
    @RequestMapping(path = "/contribute")
    public String contribute(Contribute contribute){
        Projects projects=projectService.getById(contribute.getProject()).get(0);
        int type;
        if(projects.getType()==0){
            type=0;
        }else{
            type=1;
        }
        if(contributeService.contribute(contribute)
                &&donatorCountService.insert(contribute.getUser_name(),type)
                &&donatorCountService.increase(contribute.getUser_name())){
            return "success";
        }else{
            return "fail";
        }
    }

    @ResponseBody
    @RequestMapping(path="/contributes")
    public String ReturnContributeJson(){
        List<Contribute>lists=contributeService.getContributes();
        List<Projects>projects=projectService.getProjects();
        HashMap<Integer,Projects>map=new HashMap<>();
        for(Projects x:projects){
            map.put(x.getId(),x);
        }
        for(Contribute x:lists) {
            Projects p = map.get(x.getProject());
            x.setObject(p.getObject());
            x.setProjectProvider(p.getUser_name());
            x.setUnit(p.getUnit());
        }
        return JSON.toJSONString(lists);
    }

    @ResponseBody
    @RequestMapping(path="/getContributesByUser")
    public String ReturnContributeJsonByUser(int user){
        List<Contribute>lists=contributeService.getContributeByUser(user);
        List<Projects>projects=projectService.getProjects();
        HashMap<Integer,Projects>map=new HashMap<>();
        for(Projects x:projects){
            map.put(x.getId(),x);
        }
        for(Contribute x:lists) {
            Projects p = map.get(x.getProject());
            x.setObject(p.getObject());
            x.setProjectProvider(p.getUser_name());
            x.setUnit(p.getUnit());
        }
        return JSON.toJSONString(lists);
    }

    @ResponseBody
    @RequestMapping(path="/getContributesByProject")
    public String ReturnContributeJsonByProject(int project){
        List<Contribute>lists=contributeService.getContributeByProject(project);
        System.out.println(JSON.toJSONString(lists));
        return JSON.toJSONString(lists);
    }

    @ResponseBody
    @RequestMapping(path="/getCount")
    public String getCount(){
        int project=projectService.count();
        int contribute=contributeService.count();
        HashMap<String,String>map=new HashMap<>();
        map.put("project",project+"");
        map.put("contribute",contribute+"");
        return JSON.toJSONString(map);
    }

    @ResponseBody
    @RequestMapping(path = "/getRank")
    public String getRank(int type){
        return JSON.toJSONString(donatorCountService.getRank(type));
    }
}
