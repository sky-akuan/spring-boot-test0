package com.akuan.springboot;

import com.akuan.springboot.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class SpringbootTest02ApplicationTests {


    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void contextLoads() {
    }


    @Test
    public void testUserController() throws Exception {
        RequestBuilder requestBuilder = null;

        //增
        requestBuilder = MockMvcRequestBuilders.post("/user/")
                .param("id", "1").param("name", "小明").param("age", "18");

        System.out.println(mvc.perform(requestBuilder).andReturn().getResponse().getContentAsString());

        //改
        requestBuilder = MockMvcRequestBuilders.put("/user/1")
                .param("name", "小明").param("age", "19");
        System.out.println(mvc.perform(requestBuilder).andReturn().getResponse().getContentAsString());
        //查
        requestBuilder = MockMvcRequestBuilders.get("/user/1");
        System.out.println(mvc.perform(requestBuilder).andReturn().getResponse().getContentAsString());
        // 批量查
        requestBuilder = MockMvcRequestBuilders.get("/user/");
        mvc.perform(requestBuilder).
                andExpect(MockMvcResultMatchers.status().isOk());
        System.out.println(mvc.perform(requestBuilder).andReturn().getResponse().getContentAsString());
        //删
        requestBuilder = MockMvcRequestBuilders.delete("/user/1");
        System.out.println(mvc.perform(requestBuilder).andReturn().getResponse().getContentAsString());

    }
}
