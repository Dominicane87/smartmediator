package stc21.smartmediator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import stc21.smartmediator.service.Organization;

import static org.junit.Assert.*;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class OrganizationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void deleteOrganizationTest() {

        Organization org = applicationContext.getBean(Organization.class);
        UUID orgId = org.getAll().iterator().next().getId();
        //UUID orgId = UUID.fromString("1848bc4f-b8df-4e73-9551-e3e168fee181");
        org.delete(orgId);

        assertNull(org.get(orgId));
    }
}
