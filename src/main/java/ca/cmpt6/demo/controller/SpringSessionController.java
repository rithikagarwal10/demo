package ca.cmpt6.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import ca.cmpt6.demo.model.User;
import ca.cmpt6.demo.model.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class SpringSessionController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired 
    private UserRepository userRepo;

    @GetMapping(path = "/") 
	public RedirectView process(Model model, HttpSession session) {

        // List<User> userList = userRepo.findAll();
        // System.out.println(userList);

        // @SuppressWarnings("unchecked")
		// List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
		
		// if (messages == null) {
		// 	messages = new ArrayList<>();
        //     messages.add("bobby");
        //     messages.add("chan");
		// }
		// model.addAttribute("sessionMessages", messages);

		return new RedirectView("login");

	}

    @GetMapping(path = "/login") 
    public String getLogin(Model model, HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) 
             return "login";
        else {
            request.getSession().setAttribute("session_user", user);
            model.addAttribute("user", user);
            return "protected";
        }
    }
    @PostMapping(
        path = "/login",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(@RequestBody MultiValueMap<String, String> formData, Model model, HttpServletRequest request, HttpSession session) {

        String name = formData.getFirst("name");
        int age = Integer.parseInt(formData.getFirst("age"));
        List<User> userList = userRepo.findByNameAndAge(name, age);
        if (userList.isEmpty()){
            return "login";
        }    
        else {
            User user = userList.get(0);
            request.getSession().setAttribute("session_user", user);
            model.addAttribute("user", user);
            return "protected";
        }
    }

    @GetMapping(path = "/feat1") 
    public String feature1(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null){
            return "login";
        }
        else {
            return "features/feature1";
        }
    }

	@GetMapping("/logout")  
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}

    @GetMapping("/userapi/{pid}")
    public String getUser(Model model, @PathVariable String pid){
        
        System.out.println("GET User " + pid);
        User u = userRepo.findById(1).get();
   
        model.addAttribute("user", u);
        return "showUser";
    }

    @GetMapping("/userapi")
    public String getUser(Model model){
        
        System.out.println("GET Users ");
        List<User> u = userRepo.findAll();
   
        model.addAttribute("users", u);
        return "findUsers";
    }
}
