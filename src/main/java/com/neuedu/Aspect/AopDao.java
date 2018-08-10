package com.neuedu.Aspect;

import org.springframework.stereotype.Repository;

@Repository
public interface AopDao {
    public Object addAspect(LogBean str);
}
