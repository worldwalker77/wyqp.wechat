package cn.worldwalker.game.wyqp.wechat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.worldwalker.game.wyqp.wechat.common.utils.MD5Util;
import cn.worldwalker.game.wyqp.wechat.common.utils.RequestUtil;
import cn.worldwalker.game.wyqp.wechat.dao.GameDao;
import cn.worldwalker.game.wyqp.wechat.domain.GameModel;
import cn.worldwalker.game.wyqp.wechat.domain.GameQuery;
import cn.worldwalker.game.wyqp.wechat.domain.Result;
import cn.worldwalker.game.wyqp.wechat.domain.UserSession;

@Service
public class GameServiceImpl implements GameService{
	
	@Autowired
	private GameDao gameDao;
	
	@Override
	public Result doLogin(GameQuery gameQuery) {
		Result result = new Result();
		GameModel gameModel = gameDao.getProxyByPhoneAndPassword(gameQuery);
		if (gameModel == null) {
			result.setCode(1);
			result.setDesc("账号名或密码错误");
			return result;
		}
		UserSession userSession = new UserSession();
		userSession.setProxyId(gameModel.getProxyId());
		userSession.setPlayerId(gameModel.getPlayerId());
		userSession.setNickName(gameModel.getNickName());
		userSession.setRealName(gameModel.getRealName());
		userSession.setWechatNum(gameModel.getWechatNum());
		userSession.setMobilePhone(gameModel.getMobilePhone());
		RequestUtil.setUserSession(genToken(gameQuery.getMobilePhone()), userSession);
		return result;
	}
	public String genToken(String mobilePhone){
		String temp = mobilePhone + System.currentTimeMillis() + Thread.currentThread().getName();
		return MD5Util.encryptByMD5(temp);
	}
	@Override
	public Result getProxyInfo(GameQuery gameQuery) {
		Result result = new Result();
		GameModel gameModel = null;
		try {
			gameModel = gameDao.getProxyInfo(gameQuery);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(1);
			result.setDesc("系统异常");
			return result;
		}
		if (gameModel == null) {
			result.setCode(1);
			result.setDesc("代理信息不存在");
			return result;
		}
		result.setData(gameModel);
		return result;
	}

	@Override
	public Result getBillingDetails(GameQuery gameQuery) {
		gameQuery.setProxyId(RequestUtil.getUserSession().getProxyId());
		gameQuery.setStartDate(gameQuery.getStartDate() + " 00:00:00");
		gameQuery.setEndDate(gameQuery.getEndDate()  + " 23:59:59");
		Result result = new Result();
		List<GameModel> list = null;
		Long total = 0L;
		try {
			list = gameDao.getBillingDetails(gameQuery);
			total = gameDao.getBillingDetailsCount(gameQuery);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(1);
			result.setDesc("系统异常");
			return result;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		result.setData(map);
		return result;
	}

	@Override
	public Result getMyMembers(GameQuery gameQuery) {
		gameQuery.setProxyId(RequestUtil.getUserSession().getProxyId());
		gameQuery.setStartDate(gameQuery.getStartDate() + " 00:00:00");
		gameQuery.setEndDate(gameQuery.getEndDate()  + " 23:59:59");
		Result result = new Result();
		List<GameModel> list = null;
		Long total = 0L;
		try {
			list = gameDao.getMyMembers(gameQuery);
			total = gameDao.getMyMembersCount(gameQuery);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(1);
			result.setDesc("系统异常");
			return result;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		result.setData(map);
		return result;
	}

	@Override
	public Result getWithDrawalRecords(GameQuery gameQuery) {
		gameQuery.setProxyId(RequestUtil.getUserSession().getProxyId());
		gameQuery.setStartDate(gameQuery.getStartDate() + " 00:00:00");
		gameQuery.setEndDate(gameQuery.getEndDate()  + " 23:59:59");
		Result result = new Result();
		List<GameModel> list = null;
		Long total = 0L;
		try {
			list = gameDao.getWithDrawalRecords(gameQuery);
			total = gameDao.getWithDrawalRecordsCount(gameQuery);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(1);
			result.setDesc("系统异常");
			return result;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		result.setData(map);
		return result;
	}

}
