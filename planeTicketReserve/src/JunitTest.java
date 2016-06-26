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
		System.out.println("123");
		System.out.println(
				new ServiceImp().orderAirline("AirlineCode=CA1831&Company=中国国航&StartDrome=北京首都国际机场&ArriveDrome=上海虹桥国际机场&StartTime=2016-06-25 07:30&ArriveTime=2016-06-25 09:40&ck=&listTre=[{\"agency\":{\"address\":123,\"contacts\":123,\"id\":1,\"name\":132,\"phone\":23154,\"pwd\":123},\"id\":1,\"idcard\":340826199502281500,\"name\":\"石胡\",\"phone\":13027710367,\"sex\":\"男\",\"teamid\":\"1\"}]\"")
				);
		System.out.println("123");

	}
}
