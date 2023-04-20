package RecipeBook;

import RecipeBook.appuser.AppUserController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PisProjektApplicationTests {

//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	@Disabled
//	void shouldReturnDefaultMessage() throws Exception {
//		this.mockMvc.perform(get("/"))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(content().string("First test"));
//	}
	@Autowired(required = false)
	private AppUserController appUserController;
}
