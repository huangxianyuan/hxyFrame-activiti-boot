package com.hxy.component.commandLineRunner;

import com.hxy.modules.common.cache.CodeCache;
import com.hxy.modules.common.common.Constant;
import com.hxy.modules.common.utils.RedisUtil;
import com.hxy.modules.common.utils.StringUtils;
import com.hxy.modules.sys.dao.CodeDao;
import com.hxy.modules.sys.entity.CodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的功能描述.
 * 服务启动执行
 * @Auther hxy
 * @Date 2017/11/14
 */
@Component
public class MyStartupRunner implements CommandLineRunner {

    @Autowired
    private CodeDao codeDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("服务启动执行服务启动执行服务启动执行服务启动执行");
        //CodeCache();
    }
}
