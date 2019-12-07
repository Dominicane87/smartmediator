package stc21.smartmediator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import stc21.smartmediator.model.repository.UsersRepository;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UsersRepository repository;


    @Test
    public void getUsersTest_thenStatus200()
            throws Exception {


        mvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].email").value("email1@mail.ru"));
    }

    @Test
    public void insertUserTest_thenStatus200() throws Exception {
        UUID uuid = UUID.randomUUID();
        String email = uuid + "@mail.ru";
        StringBuilder content = new StringBuilder();
        content.append("{");
        content.append("\"email\":\"" + email + "\",");
        content.append("\"password_hash\":\"password_" + uuid + "\",");
        content.append("\"full_name\":\"name_" + uuid + "\"");
        content.append("}");

        mvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("email").value(email));
    }
}
