package cn.worldwalker.game.wyqp.wechat.service;

import cn.worldwalker.game.wyqp.wechat.domain.GameQuery;
import cn.worldwalker.game.wyqp.wechat.domain.Result;

public interface GameService {
	
	public Result doLogin(GameQuery gameQuery);
	
	public Result getProxyInfo(GameQuery gameQuery);
	
	public Result getBillingDetails(GameQuery gameQuery);
	
	public Result getMyMembers(GameQuery gameQuery);
	
	public Result getWithDrawalRecords(GameQuery gameQuery);
	
}
