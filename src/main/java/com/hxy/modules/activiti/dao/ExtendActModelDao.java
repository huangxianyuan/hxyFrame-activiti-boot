package com.hxy.modules.activiti.dao;

import com.hxy.modules.activiti.entity.ExtendActModelEntity;
import com.hxy.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 流程模板扩展表
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2017-07-14 11:02:01
 */
@Mapper
public interface ExtendActModelDao extends BaseDao<ExtendActModelEntity> {

    /**
     * 根据模型id获取流程模型和业务相关信息
      * @param modelId
     * @return
     */
    ExtendActModelEntity getModelAndBusInfo(String modelId);

	
}
