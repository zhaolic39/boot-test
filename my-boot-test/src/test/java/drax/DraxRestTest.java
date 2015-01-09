package drax;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;

import drax.entity.DxApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DraxApplication.class)
@WebAppConfiguration
public class DraxRestTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
    
    @Test
    public void testGet() throws Exception {
        mvc.perform(get("/apps/2c9086f048442f4401484443aa510004"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2c9086f048442f4401484443aa510004"))
                .andReturn();
    }
    
    @Test
    public void testCreateAndDelete() throws Exception {
        DxApp app = new DxApp();
        app.setName("Root Create Test");
        MvcResult mr = mvc.perform(post("/apps").contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(app)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn();
        String result = mr.getResponse().getContentAsString();
        app = JSON.parseObject(result, DxApp.class);
        Assert.assertNotNull(app);
        
        mvc.perform(delete("/apps/" + app.getId()))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isNoContent())
            .andReturn();
    }
}
