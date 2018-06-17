import com.star.service.btc.QueryBTCBlockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * @Author 张楠
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

    @Test
    public void test1() {

        queryBTCBlockService.queryBlock();
        System.out.println(1);
    }

}
