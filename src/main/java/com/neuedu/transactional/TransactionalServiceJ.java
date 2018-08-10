package com.neuedu.transactional;

import org.springframework.stereotype.Service;

@Service
public interface TransactionalServiceJ {
    public  void updateMoney(String fromName,String toName,int money);
}
