package self.nacos.client.service;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.nacos.client.clients.Server1Client;
import self.nacos.client.clients.Server2Client;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/28 15:04
 */
@Service
public class TestService {

    @Autowired
    private Server1Client server1Client;
    @Autowired
    private Server2Client server2Client;

    @GlobalTransactional(name = "ycs_tx_group", rollbackFor = Exception.class)
    public void test(int pointCount, int count) {
        System.out.println(RootContext.getXID());
        System.out.println("------------------------------------------------------------");
        System.out.println("开始增加积分");
        server1Client.addPointCount(pointCount);
        System.out.println("增加积分结束");
        System.out.println("------------------------------------------------------------");
        System.out.println("开始扣减库存");
        server2Client.cutGoodsCount(count);
        System.out.println("扣减库存结束");
        System.out.println("------------------------------------------------------------");
    }

    public String getNow() {
        return "积分:" + server1Client.getPointCount() + ",库存:" + server2Client.getGoodsCount();
    }

}
