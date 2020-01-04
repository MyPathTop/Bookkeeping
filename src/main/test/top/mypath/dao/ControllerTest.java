package top.mypath.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author 李亚林
 * @date 2019/12/23 23:44
 */
public class ControllerTest extends BaseTest {
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void loginTest() throws Exception{
        String responseString = mockMvc.perform(
                post("/user/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username","15703816960")
                .param("password","123456")
        ).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.println("-----返回的json = " + responseString);
    }
}
