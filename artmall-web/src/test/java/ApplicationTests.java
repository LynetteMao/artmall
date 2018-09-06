import com.artmall.pojo.Student;
import com.artmall.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author
 * @create 2018-08-24 15:22
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTests.class)
//@ComponentScan(basePackages = "com.artmall")
//@MapperScan(basePackages = "com.artmall.mapper")

public class ApplicationTests {

    @Resource
    StudentService studentService;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void test(){
        Long id = new Long(1000000000);
        Student student=studentService.selectStudentById(id);
        System.out.println("student为:"+student);
    }
}
