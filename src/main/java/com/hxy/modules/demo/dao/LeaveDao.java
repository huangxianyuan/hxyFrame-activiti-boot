package com.hxy.modules.demo.dao;

import com.hxy.modules.common.dao.BaseDao;
import com.hxy.modules.demo.entity.LeaveEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 请假流程测试
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2017-07-31 13:33:23
 */
@Mapper
public interface LeaveDao extends BaseDao<LeaveEntity> {
	
}
