package cn.worldwalker.game.wyqp.wechat.dao;

import java.util.List;

import cn.worldwalker.game.wyqp.wechat.domain.GameModel;
import cn.worldwalker.game.wyqp.wechat.domain.GameQuery;

public interface GameDao {
	
	public List<GameModel> getMyMembers(GameQuery gameQuery);
	public Long getMyMembersCount(GameQuery gameQuery);
	
	public List<GameModel> getBillingDetails(GameQuery gameQuery);
	public Long getBillingDetailsCount(GameQuery gameQuery);
	
	public List<GameModel> getWithDrawalRecords(GameQuery gameQuery);
	public Long getWithDrawalRecordsCount(GameQuery gameQuery);
	
	public GameModel getProxyInfo(GameQuery gameQuery);
	
	public GameModel getProxyByPhoneAndPassword(GameQuery gameQuery);
	
	public GameModel getUserByCondition(GameQuery gameQuery);
	
	public Integer updateRoomCardNumByPlayerId(GameQuery gameQuery);
	
	
}
