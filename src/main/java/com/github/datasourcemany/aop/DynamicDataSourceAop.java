package com.github.datasourcemany.aop;

import com.github.datasourcemany.model.User;
import com.github.datasourcemany.route.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAop {


    @Pointcut("execution(public * com.github.datasourcemany.service.*.*(..))")
    public void pointCut(){};


    /**
     * 切换数据源
     * @param point
     */
    @Before("pointCut()")
    public void switchDataSource(JoinPoint point) {
        User user = (User)point.getArgs()[0];
        if("user2".equals(user.getName())){
            DynamicDataSourceContextHolder.setDataSourceKey("db2");
        }
    }

    /**
     * 重置数据源
     * @param point
     */
    @After("pointCut()")
    public void restoreDataSource(JoinPoint point) {
        // 将数据源置为默认数据源
        DynamicDataSourceContextHolder.clearDataSourceKey();
        System.out.println("Restore DataSource to [" + DynamicDataSourceContextHolder.getDataSourceKey()
                + "] in Method [" + point.getSignature() + "]");
    }
}
