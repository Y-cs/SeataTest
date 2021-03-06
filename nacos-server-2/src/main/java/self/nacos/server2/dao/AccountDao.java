package self.nacos.server2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import self.nacos.server2.domain.Account;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 15:32
 */
@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
}
