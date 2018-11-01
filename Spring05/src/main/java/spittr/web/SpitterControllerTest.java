package spittr.web;
 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
 
import org.junit.Test;
import org.mockito.Mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spittr.Spitter;
import spittr.ValidateUtils;
import spittr.data.SpitterRepository;
 
public class SpitterControllerTest {
 
    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
    }
    
    @Test
    public void shouldPeocessRegistration() throws Exception {
    
    	SpitterRepository mockRepository = mock(SpitterRepository.class);
    	Spitter unsaved = new Spitter("1", "2", "3", "4");
    	String validate = ValidateUtils.validate(unsaved);
    	System.out.println(validate);
    	Spitter saved = new Spitter(24L,"1", "2", "3", "4");
    	when(mockRepository.save(unsaved)).thenReturn(saved);
    	
    	SpitterController controller = new SpitterController();
    	MockMvc mockMvc = standaloneSetup(controller).build();
    	mockMvc.perform(post("/spitter/register")
	    			.param("firstName", "1")
	    			.param("lastName", "2")
	    			.param("username", "3")
	    			.param("Register", "4"))
    		.andExpect(redirectedUrl("/spitter/3"));
    	
    	verify(mockRepository, atLeastOnce()).save(unsaved);
    	
    }
    

}