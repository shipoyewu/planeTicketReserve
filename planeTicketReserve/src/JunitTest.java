import java.util.Date;

import javax.annotation.Resource;

import org.apache.axis.Message;
import org.apache.axis.message.MessageElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mps.daoImp.AgencyDaoImp;
<<<<<<< HEAD
import com.mps.daoImp.ParticipateDaoImp;
import com.mps.daoImp.TeamDaoImp;
=======
import com.mps.daoImp.OrdersDaoImp;
>>>>>>> branch 'master' of https://github.com/shipoyewu/planeTicketReserve
import com.mps.daoImp.TravellerDaoImp;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
	@Resource
	AgencyDaoImp agencyDaoImp;
	@Resource
	TravellerDaoImp travellerDaoImp;
	@Resource
<<<<<<< HEAD
	ParticipateDaoImp participateDaoImp;
	@Resource
	TeamDaoImp teamDaoImp;
=======
	OrdersDaoImp ordersDaoImp;
	
>>>>>>> branch 'master' of https://github.com/shipoyewu/planeTicketReserve
	@Test
	public void test(){
<<<<<<< HEAD
		//System.out.println(agencyDaoImp.checkPassword("1302777", "123456"));
		try {
			System.out.println(travellerDaoImp.get(1).getAgency().getAddress());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(participateDaoImp.getParticipByTeam(1).size());
=======
		System.out.println(ordersDaoImp.getCountOfAirline("asda", new Date()));
>>>>>>> branch 'master' of https://github.com/shipoyewu/planeTicketReserve
	}
}
