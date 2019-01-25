package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class mvcController {
	@RequestMapping("/hello")
    public String hello(){        
        return "hello";
    }
	
	@RequestMapping("/user")
	@ResponseBody
	public User getUser() {
		User user = new User();
		user.setName("ÀîËÄ");
		user.setAge(5);
		return user;
	}
	
	
}
