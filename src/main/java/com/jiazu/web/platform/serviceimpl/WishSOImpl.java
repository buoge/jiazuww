package com.jiazu.web.platform.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiazu.global.constants.MapperConstant;
import com.jiazu.web.base.entity.Pager;
import com.jiazu.web.base.service.BaseSO;
import com.jiazu.web.platform.dao.WishDao;
import com.jiazu.web.platform.entity.Wish;
import com.jiazu.web.platform.service.WishSO;

@Service
public class WishSOImpl extends BaseSO implements WishSO {

	@Autowired
	private WishDao dao;
	
	@Override
	public boolean add(Wish wish) {
		try {
			dao.insert(wish);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public List<Wish> getList(String uid) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put(MapperConstant.groupuid, uid);
			return dao.getList(map);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Wish> getList(Pager pager) {
		try {
			Map<String, Object> map = getParamMap(pager);
			return dao.getList(map);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean delete(String uid) {
		try {
			dao.delete(uid);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

}
