package drax;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import drax.dao.DxAppDao;
import drax.entity.DxApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DraxApplication.class)
public class DraxApplicationTests {

    @Autowired
    DxAppDao dxAppDao;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testCreate() {
        DxApp app = new DxApp();
        app.setName("Boot Test");
        dxAppDao.save(app);
        
//        app = dxAppDao.findByName("Boot Test");
//        Assert.assertNotNull(app.getId());
    }
    
    @Test
    public void testFindByPropety() {
        DxApp app = dxAppDao.findByName("美特斯邦威1");
        Assert.assertEquals("美特斯邦威1", app.getName());
    }
    
    @Test
    public void testFindById() {
        DxApp app = dxAppDao.findOne("4028818247c55c0f0147c58520870014");
        Assert.assertEquals("222", app.getName());
    }
    
    @Test
    public void testInvokeSql() {
        String sql = "select id from dx_app where id= ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, "4028818247c55c0f0147c58520870014");
        System.out.println(list.toString());
        Assert.assertEquals(1, list.size());
    }
    
    @Test
    public void testQueryMethod() {
        List<Object[]> list = dxAppDao.getByCreateBy("admin");
        Assert.assertEquals(5, list.size());
    }
}
