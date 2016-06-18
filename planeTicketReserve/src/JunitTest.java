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
		System.out.println("111");
		Agency agency = new Agency();
		agency.setAddress("zonzansww是是是");
		agency.setName("snice");
		agency.setPhone("13027711597");
		agency.setPwd("123456");
		agency.setContacts("Ok");
		System.out.println("1111");
		try{
			agencyDaoImp.save(agency);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("12312");
	}
}
