import com.star.service.btc.QueryAllTokenService;
import com.star.service.btc.QueryBTCBlockConsumerServiceImpl;
import com.star.service.btc.QueryBTCBlockProducerServiceImpl;
import com.star.service.btc.QueryBTCBlockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * @author 张楠
 * @Date 2018-06-2018/6/17 下午1:45
 * @Describe
 * @Version
 * @since
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test/**/*.xml"})
public class BtcTest {

    @Resource
    private QueryBTCBlockService queryBTCBlockService;

    @Autowired
    private QueryBTCBlockProducerServiceImpl queryBTCBlockProducerService;

    @Autowired
    private QueryBTCBlockConsumerServiceImpl queryBTCBlockConsumerService;

    @Resource
    private QueryAllTokenService queryAllTokenService;

    @Test
    public void test1() {

        queryBTCBlockService.queryBlock();
        System.out.println(1);
    }

    @Test
    public void test2() {

        //new Thread(queryBTCBlockProducerService).start();
        //new Thread(queryBTCBlockV2Service.new Consumer()).start();
/*
        queryBTCBlockServiceV2.queryBlock();*/
        QueryBTCBlockProducerServiceImpl test3 = new QueryBTCBlockProducerServiceImpl();
        Thread produce1 = new Thread(test3);
        produce1.start();
        //Thread produce2 = new Thread(test3);
        //produce2.start();

        Thread consumer = new Thread(queryBTCBlockConsumerService);
        consumer.start();

        try {
            produce1.join();
            //produce2.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(1);
    }


    @Test
    public void test3(){
        queryAllTokenService.queryAllToken();
    }
}
