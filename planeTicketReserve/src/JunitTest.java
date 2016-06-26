import javax.annotation.Resource;

import org.apache.axis.Message;
import org.apache.axis.message.MessageElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mps.daoImp.AgencyDaoImp;
import com.mps.daoImp.OrdersDaoImp;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
	@Resource
	AgencyDaoImp agencyDaoImp;
	@Resource
	OrdersDaoImp ordersDaoimp;
	@Test
	public void test(){
		
		try{
			System.out.println(ordersDaoimp.getFlightList());
			System.out.println(ordersDaoimp.getFlightList().toString()+"liushuo");
			/*System.out.println(ordersDaoimp.getFlighttest());*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		

	}
}
