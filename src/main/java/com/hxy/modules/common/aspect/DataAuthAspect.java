package com.hxy.modules.common.aspect;

import com.hxy.modules.common.annotation.DataAuth;
import com.hxy.modules.common.common.Constant;
import com.hxy.modules.common.exception.MyException;
import com.hxy.modules.common.utils.StringUtils;
import com.hxy.modules.common.utils.UserUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 类DataAuthAspect的功能描述:
 * 数据权限过滤 切面类
 * @auther hxy
 * @date 2017-11-16 16:04:03
 */
@Aspect
@Component
public class DataAuthAspect {
    @Pointcut("@annotation(com.hxy.modules.common.annotation.DataAuth)")
    public void dataAuthPointcut(){

    }

    @Before("dataAuthPointcut()")
    public void dataAuth(JoinPoint joinPoint) throws Throwable{
        //获取方面第一个参数
        Object params = joinPoint.getArgs()[0];
        //如果参数为Map类型
        if(params != null && params instanceof Map){
            String currentUserId = UserUtils.getCurrentUserId();
            //如果当前用户不为超级管理员，则需要进行数据过滤
            if(!currentUserId.equals(Constant.SUPERR_USER)){
                ((Map) params).put("dataAuthSql",dataAuthSql(joinPoint));
            }
        }else {
            throw new MyException("需要数据权限过滤，需要查询方法的第一个参数为Map类型，且不能为NULL");
        }
    }

    public String dataAuthSql(JoinPoint joinPoint){
        //获取目标方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //通过方法签名，获取数据过滤注解
        DataAuth annotation = signature.getMethod().getAnnotation(DataAuth.class);
        //通过注解获取别名
        String tableAlias = annotation.tableAlias();
        if(!StringUtils.isEmpty(tableAlias)){
            tableAlias+=".";
        }
        StringBuilder dataAuthSql = new StringBuilder();
        dataAuthSql.append(" AND (");

        //获取用户授权部门
        String baids = UserUtils.getDateAuth(Constant.DataAuth.BA_DATA.getValue());
        //获取用户授权机构
        String bapids = UserUtils.getDateAuth(Constant.DataAuth.BAP_DATA.getValue());
        dataAuthSql.append(tableAlias);
        dataAuthSql.append("create_id = ");
        dataAuthSql.append("'" + UserUtils.getCurrentUserId() + "'");
        if(baids != null && !StringUtils.isEmpty(baids)){
            dataAuthSql.append("OR ");
            dataAuthSql.append(tableAlias);
            dataAuthSql.append("baid IN(");
            dataAuthSql.append(baids);
            dataAuthSql.append(")");
        }
        if(bapids != null && !StringUtils.isEmpty(bapids)){
            dataAuthSql.append("OR ");
            dataAuthSql.append(tableAlias);
            dataAuthSql.append("bapid IN(");
            dataAuthSql.append(bapids);
            dataAuthSql.append(")");
        }
        dataAuthSql.append(")");
        return dataAuthSql.toString();
    }

}
