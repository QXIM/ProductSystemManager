import com.neuedu.transactional.TransactionalService;
import com.neuedu.transactional.TransactionalServiceJ;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TransactionalTest {
    ApplicationContext applicationContext;
    @Before
public  void before(){
        applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
    }


    @Test
    public  void y(){

        TransactionalServiceJ p=applicationContext.getBean(TransactionalServiceJ.class);
        p.updateMoney("zhangsan","zhaosi",60);

    }

}
