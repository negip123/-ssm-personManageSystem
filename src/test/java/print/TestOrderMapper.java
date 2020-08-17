package print;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.neuedu.print.dao.OrdersMapper;
import com.neuedu.print.model.Orders;
//spring测试
@RunWith(SpringJUnit4ClassRunner.class)
//SSM框架的配置文件
@ContextConfiguration(locations = {"classpath:mybatis-config.xml",
		"classpath:applicationContext.xml",
		"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
//web
@WebAppConfiguration
public class TestOrderMapper {
	@Autowired
	private OrdersMapper orderMapper;
	
	@Test
	public void test_selectByPrimaryKey() {
		//编号
		Integer id = new Integer(5);
		//查询编号为5的信息
		Orders order = orderMapper.selectByPrimaryKey(id);
		//通过断言判断测试结果是否正确：期望值，是否等于，目标值
		assertEquals(id.intValue(), order.getId().intValue());
	}


}
