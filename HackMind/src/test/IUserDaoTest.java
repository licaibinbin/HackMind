import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackmind.dao.IUserDao;
import com.hackmind.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Resource
    private IUserDao userDao;

    @Test
    public void test() throws JsonProcessingException {
        User user = userDao.selectUser(1);
//        ObjectMapper mapper=new ObjectMapper();
//        System.out.print(mapper.writeValueAsString(user));
        System.out.print(user.getUsername());
    }
}
