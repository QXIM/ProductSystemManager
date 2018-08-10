package com.neuedu.transactional;

import org.springframework.stereotype.Repository;

@Repository
public interface TransactionalDao {

        void updateMoney(String name,int money);

}
