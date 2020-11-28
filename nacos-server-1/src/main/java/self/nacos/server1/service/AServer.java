package self.nacos.server1.service;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.nacos.server1.dao.AccountDao;
import self.nacos.server1.domain.Account;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 14:39
 */
@Service
public class AServer {

    @Autowired
    private AccountDao accountDao;
    @GlobalTransactional(name = "ycs_tx_group",rollbackFor = Exception.class)
    public void addPointCount(int pointCount){
        System.out.println(RootContext.getXID());
        System.out.println("尝试增加"+pointCount+"积分");
        Account account = accountDao.getOne(1L);
        account.setPointCount(account.getPointCount()+pointCount);
        accountDao.save(account);
        System.out.println("已增加"+pointCount+"积分");
    }

    public long getPointCount(){
        Account account = accountDao.getOne(1L);
        return account.getPointCount();
    }


}
