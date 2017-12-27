package com.hxy.modules.activiti.dao;

import com.hxy.modules.activiti.entity.ExtendActNodefieldEntity;
import com.hxy.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 流程节点对应的条件
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2017-07-24 13:28:51
 */
@Mapper
public interface ExtendActNodefieldDao extends BaseDao<ExtendActNodefieldEntity> {

    /**
     * 根据节点id删除
     * @param nodeId
     */
    void delByNodeId(String nodeId);

    /**
     * 根据节点集合查询
     * @param nodes
     * @return
     */
    List<ExtendActNodefieldEntity> queryByNodes(List<String> nodes);
}
