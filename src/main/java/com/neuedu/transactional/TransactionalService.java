package com.neuedu.transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalService implements TransactionalServiceJ {

    @Autowired
    @Qualifier("transactionalDaoImpl")
    TransactionalDao transactionalDao;
@Transactional
    public  void updateMoney(String fromName,String toName,int money){
        System.out.println(money);

        transactionalDao.updateMoney(fromName,200-money);
       int a=1/0;
        transactionalDao.updateMoney(toName,200+money);


    }

}
