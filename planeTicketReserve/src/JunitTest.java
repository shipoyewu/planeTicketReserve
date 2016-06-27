import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mps.daoImp.AgencyDaoImp;
import com.mps.daoImp.ParticipateDaoImp;
import com.mps.daoImp.TeamDaoImp;
import com.mps.daoImp.OrdersDaoImp;
import com.mps.daoImp.TravellerDaoImp;
import com.mps.model.Participate;
import com.mps.model.Team;
import com.mps.model.Traveller;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;



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

		try {
//			TaobaoClient client = 
//					new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest","23390281", "14d2de25dc8047fc35985bce7d2aae3d");
//			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//			req.setExtend("123456");
//			req.setSmsType("normal");
//			req.setSmsFreeSignName("mps机票预定");
//			req.setSmsParamString("{\"code\":\"1234\",\"product\":\"alidayu\"}");
//			req.setRecNum("13027710367,15738813687,13027711597");
//			req.setSmsTemplateCode("SMS_10885001");
//			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
//			System.out.println(rsp.getBody());
			Team t = new Team();
			t.setAgency(agencyDaoImp.get(3));
			t.setStatus(0);
			t.setType(2);
			t.setName("软三毕业团");
			t.setPrincipal("王健");
			t.setPrinphone("13984765342");
			teamDaoImp.save(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
