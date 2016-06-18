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
		agency.setAddress("����ʡ֣���и�������ѧ���100��");
		agency.setName("�Ǻ���������");
		agency.setPhone("13027711597");
		agency.setPwd("123456");
		agency.setContacts("趸��");
		agencyDaoImp.save(agency);
		
	}
}
