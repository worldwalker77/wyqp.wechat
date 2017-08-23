package cn.worldwalker.game.wyqp.wechat.service;

import cn.worldwalker.game.wyqp.wechat.domain.GameQuery;
import cn.worldwalker.game.wyqp.wechat.domain.Result;

public interface GameService {
	
	public Result doLogin(GameQuery proxyQuery);
	
	public Result getProxyInfo(GameQuery proxyQuery);
	
	public Result getBillingDetails(GameQuery proxyQuery);
	
	public Result getMyMembers(GameQuery proxyQuery);
	
	public Result getWithDrawalRecords(GameQuery proxyQuery);
	
}
