import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.axis.Message;
import org.apache.axis.message.MessageElement;
import org.apache.cxf.wsdl.TTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mps.daoImp.AgencyDaoImp;
import com.mps.daoImp.ParticipateDaoImp;
import com.mps.daoImp.TeamDaoImp;
import com.mps.daoImp.OrdersDaoImp;
import com.mps.daoImp.ParticipateDaoImp;
import com.mps.daoImp.TeamDaoImp;
import com.mps.daoImp.TravellerDaoImp;
import com.mps.service.ServiceImp;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
	@Resource
	AgencyDaoImp agencyDaoImp;
	@Resource
	TravellerDaoImp travellerDaoImp;
	@Resource
	ParticipateDaoImp participateDaoImp;
	@Resource
	TeamDaoImp teamDaoImp;
	@Resource
	OrdersDaoImp ordersDaoImp;
	
	
	@Test
	public void test(){
		
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		


	}
}
