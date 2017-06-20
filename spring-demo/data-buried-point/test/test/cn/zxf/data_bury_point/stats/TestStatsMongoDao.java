package test.cn.zxf.data_bury_point.stats;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zxf.data_bury_point.DataBuryPointApplication;
import cn.zxf.data_bury_point.stats.StatsMongoDao;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest( classes = DataBuryPointApplication.class )
@RunWith( SpringJUnit4ClassRunner.class )
@Slf4j
public class TestStatsMongoDao {

    @Autowired
    private StatsMongoDao dao;

    @Test
    public void testStats() {
	System.out.println();
	log.info( "stats: {}", dao.userVisitStats() );
	System.out.println();
    }

}
