package com.hxy.modules.demo.service.impl;

import com.hxy.modules.common.common.Constant;
import com.hxy.modules.common.exception.MyException;
import com.hxy.modules.common.page.Page;
import com.hxy.modules.common.page.PageHelper;
import com.hxy.modules.common.utils.StringUtils;
import com.hxy.modules.common.utils.UserUtils;
import com.hxy.modules.common.utils.Utils;
import com.hxy.modules.demo.dao.LeaveDao;
import com.hxy.modules.demo.entity.LeaveEntity;
import com.hxy.modules.demo.service.LeaveService;
import com.hxy.modules.sys.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	private LeaveDao leaveDao;
	
	@Override
	public LeaveEntity queryObject(String id){
		if(StringUtils.isEmpty(id)){
			new MyException("id不为空!");
		}
		return leaveDao.queryObject(id);
	}
	
	@Override
	public List<LeaveEntity> queryList(Map<String, Object> map){
		return leaveDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return leaveDao.queryTotal(map);
	}
	
	@Override
	public void save(LeaveEntity leave){
		UserEntity currentUser = UserUtils.getCurrentUser();
		leave.setCode(Utils.getCode("D"));
		leave.setStatus(Constant.ActStauts.DRAFT.getValue());
		leave.setCreateId(currentUser.getId());
		leave.setCreateTime(new Date());
		leave.setId(Utils.uuid());
		leave.setStatus(Constant.ActStauts.DRAFT.getValue());
		leave.setUserId(UserUtils.getCurrentUserId());
		leave.setBapid(currentUser.getBapid());
		leave.setBaid(currentUser.getBaid());//未改

		leaveDao.save(leave);
	}
	
	@Override
	public void update(LeaveEntity leave){
		if(StringUtils.isEmpty(leave.getId())){
			throw new MyException("请假id不能为空");
		}
		leave.setUpdateId(UserUtils.getCurrentUserId());
		leave.setUpdateTime(new Date());
		leaveDao.update(leave);
	}
	
	@Override
	public int delete(String id){
	    if(StringUtils.isEmpty(id)){
	        throw  new MyException("请假id不能为空");
        }
		return leaveDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		leaveDao.deleteBatch(ids);
	}

	@Override
	public Page<LeaveEntity> findPage(LeaveEntity leaveEntity, int pageNum) {
		PageHelper.startPage(pageNum, Constant.pageSize);
		leaveDao.queryList(leaveEntity);
		return PageHelper.endPage();
	}

}
