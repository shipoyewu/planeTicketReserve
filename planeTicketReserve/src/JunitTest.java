import java.util.Date;

import javax.annotation.Resource;

import org.apache.axis.Message;
import org.apache.axis.message.MessageElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mps.daoImp.AgencyDaoImp;
import com.mps.daoImp.OrdersDaoImp;
import com.mps.daoImp.TravellerDaoImp;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
	@Resource
	AgencyDaoImp agencyDaoImp;
	@Resource
	TravellerDaoImp travellerDaoImp;
	@Resource
	OrdersDaoImp ordersDaoImp;
	
	@Test
	public void test(){
		System.out.println(ordersDaoImp.getCountOfAirline("asda", new Date()));
	}
}
