package stc21.smartmediator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import stc21.smartmediator.model.repository.OrganizationsRepository;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class OrganizationControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrganizationsRepository repository;

    @Test
    public void insertOrganizationTest_thenStatus200() throws Exception {
        UUID uuid = UUID.randomUUID();
        String full_name = "org_full_name_" + uuid;
        StringBuilder content = new StringBuilder();
        content.append("{");
        content.append("\"full_name\":\"" + full_name + "\",");
        content.append("\"name\":\"org_name_" + uuid + "\",");
        content.append("\"inn\":\"inn_" + uuid + "\",");
        content.append("\"address\":\"address_" + uuid + "\"");
        content.append("}");

        mvc.perform(post("/organization")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("fullName").value(full_name));
    }
}
