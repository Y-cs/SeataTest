package self.nacos.server2.service;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.nacos.server2.dao.GoodsDao;
import self.nacos.server2.domain.Goods;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 14:39
 */
@Service
public class BServer {

    @Autowired
    private GoodsDao goodsDao;

    @GlobalTransactional(name = "ycs_tx_group",rollbackFor = Exception.class)
    public void cutGoodsCount(int count) throws Exception {
        System.out.println(RootContext.getXID());
        System.out.println("尝试扣减库存");
        Goods goods = goodsDao.getOne(1L);
        long countNum = goods.getCountNum() - count;
        System.out.println("扣减库存之后的结果:" + countNum);
        if (countNum < 0) {
            System.out.println("扣减库存失败,处理回滚");
            throw new Exception("error");
        }
        goods.setCountNum(countNum);
        goodsDao.save(goods);
        System.out.println("扣减库存成功");
    }

    public long getGoodsCount(){
        Goods goods = goodsDao.getOne(1L);
        return goods.getCountNum();
    }

}
