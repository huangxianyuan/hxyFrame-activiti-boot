package com.hxy.modules.sys.dao;


import com.hxy.modules.common.dao.BaseDao;
import com.hxy.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类SysLogDao的功能描述:
 * 系统日志
 * @auther hxy
 * @date 2017-08-25 16:14:57
 */
@Mapper
public interface SysLogDao extends BaseDao<SysLogEntity> {
	
}
