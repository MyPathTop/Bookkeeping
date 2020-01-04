package top.mypath.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

/**
 * @author 李亚林
 * @date 2019/12/23 17:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/resource")
@ContextConfiguration(locations = {"classpath:springMVC.xml","classpath:mybatis-config.xml","classpath:applicationContext.xml"})
public class BaseTest {
    @Test
    public void test() throws IOException {

    }

}
