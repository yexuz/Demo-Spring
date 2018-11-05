package spittr.web;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpitterRepository;
 
@Controller
@RequestMapping("/spitter")
public class SpitterController {
 
    // 处理来自/spitter/register的get请求
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
    	model.addAttribute(new Spitter());
        return "registerForm";
    }
    
    private SpitterRepository spitterRepository;

    public SpitterController() {
    }

    // 注入SpitterRepository
    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    // ps: 很重要一点需要注意，Errors参数要紧跟在带有@Valid注解的参数后面
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors) {
         if(errors.hasErrors()) {
        	 return "registerForm";
         }
    	// 保存Spitter
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }


}