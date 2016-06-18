import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mps.daoImp.AgencyDaoImp;
import com.mps.model.Agency;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JunitTest {
	@Resource
	AgencyDaoImp agencyDaoImp;
	public JunitTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void test(){
		Agency agency = new Agency();
		agency.setAddress("河南省郑州市高新区科学大道100号");
		agency.setName("呵呵哒旅行社");
		agency.setPhone("13027711597");
		agency.setPwd("123456");
		agency.setContacts("瓒哥哥");
		agencyDaoImp.save(agency);
		
	}
}
