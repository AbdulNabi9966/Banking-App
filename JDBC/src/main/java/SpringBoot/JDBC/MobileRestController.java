package SpringBoot.JDBC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileRestController {

	@Autowired
	MobileConnection mb;
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String SayHello() {
		return "Hello World! How are you Today?";
	}
	
	@RequestMapping("hellojsp")
	public String Sayhi() {
		return "hello.jsp";
	}

	 @GetMapping("/mobile/{id}")
	 public  Mobiles getmobile(@PathVariable int id) {

	    return mb.getMobile(id);
	  }

	 @GetMapping("/mobiles")
	 public  List<Mobiles> getMobiles() {

	    return mb.getMobiles();
	  }
	 
	 @PutMapping("/mobile/{mob_id}")
	 public int updateMobile(@PathVariable int mob_id) {
		 return mb.updateMobile(mob_id);
	 }
	 
	 @PostMapping("/mobile")
	 public int createMobile(@RequestBody Mobiles mob) {
	 		 System.out.println(mob.toString());
	 		 return mb.insertMobile(mob);
	 	 }
	 
	 @PostMapping("/mobiles")
	 public int createMobiles(@RequestBody List<Mobiles> mob) {
	 		 System.out.println(mob.toString());
	 		 return mb.insertMobiles(mob);
	 	 }
	 
	 @DeleteMapping("/mobile/{id}")
	 public int deleteMobile(@PathVariable int id) {
	 		 System.out.println(id);
	 		 return mb.deleteMobile(id);
	 	 }
}
