package com.hxy.modules.sys.dao;

import com.hxy.modules.common.dao.BaseDao;
import com.hxy.modules.sys.entity.UserEntity;
import com.hxy.modules.sys.entity.UserWindowDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 系统用户表
 * 
 * @author chenshun
 * @email huangxianyuan@gmail.com
 * @date 2017-05-03 09:41:38
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

    /**
     * 根据登陆用户查询有效的用户
     * @param loginName
     * @return
     */
    UserEntity queryByLoginName(String loginName);

    /**
     * 用户对应的机构id,数据权限控制
     * @param userId
     * @param type 结点类型：0=根节点 ，1=机构，2=部门 具体见:Constant 类
     * @return key:organId 组织id key:roleId 角色id
     */
    List<Map<String,Object>> queryOrganIdByUserId(@Param("userId")String userId, @Param("type") String type);

    /**
     * 用户对应的机构id,数据权限控制
     * @param userId
     * @param type 结点类型：0=根节点 ，1=机构，2=部门 具体见:Constant 类
     */
    List<String> queryOrganIdByUserIdArray(@Param("userId") String userId,@Param("type") String type);


    /**
     * 根据实体类查询
     * @param userWindowDto
     * @return
     */
    List<UserWindowDto> queryListByBean(UserWindowDto userWindowDto);

    /**
     * 更新密码
     * @param params key:passWord 密码， key:id 主键id
     * @return
     */
    int updatePassword(Map<String, Object> params);

    /**
     * 批量重置密码
     * @param params key:passWord 密码， key:sid 主键ids
     * @return
     */
    int resetPassWord(Map<String, Object> params);

    /**
     * 批量更新用户状态
     * @param params key:ids 用户ids
     * @return
     */
    int updateBatchStatus(Map<String, Object> params);



}
