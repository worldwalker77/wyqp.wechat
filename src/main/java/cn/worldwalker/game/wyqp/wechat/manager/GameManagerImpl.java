package cn.worldwalker.game.wyqp.wechat.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.worldwalker.game.wyqp.wechat.common.exception.BusinessException;
import cn.worldwalker.game.wyqp.wechat.common.exception.ExceptionEnum;
import cn.worldwalker.game.wyqp.wechat.common.utils.RequestUtil;
import cn.worldwalker.game.wyqp.wechat.dao.GameDao;
import cn.worldwalker.game.wyqp.wechat.domain.GameModel;
import cn.worldwalker.game.wyqp.wechat.domain.GameQuery;

@Component
public class GameManagerImpl implements GameManager{
	@Autowired
	private GameDao gameDao;
	@Override
	public void giveAwayRoomCards(Integer toPlayerId, Integer changeRoomCardNum) {
		Integer playerId = RequestUtil.getUserSession().getPlayerId();
		GameQuery gameQuery = new GameQuery();
		gameQuery.setPlayerId(playerId);
		GameModel model = gameDao.getUserByCondition(gameQuery);
		if (model.getRoomCardNum() < changeRoomCardNum) {
			throw new BusinessException(ExceptionEnum.ROOM_CARD_NOT_ENOUGH);
		}
		gameQuery.setChangeRoomCardNum(changeRoomCardNum * (-1));
		gameQuery.setRoomCardNum(model.getRoomCardNum());
		/**扣除赠送人的房卡数*/
		Integer res = gameDao.updateRoomCardNumByPlayerId(gameQuery);
		if (res < 1) {
			throw new BusinessException(ExceptionEnum.GIVE_AWAY_ROOM_CARD_FAIL);
		}
		/**增加受赠人的房卡数*/
		GameQuery gameQuery1 = new GameQuery();
		gameQuery1.setPlayerId(toPlayerId);
		model = gameDao.getUserByCondition(gameQuery1);
		gameQuery1.setChangeRoomCardNum(changeRoomCardNum);
		gameQuery1.setRoomCardNum(model.getRoomCardNum());
		res = gameDao.updateRoomCardNumByPlayerId(gameQuery1);
		if (res < 1) {
			throw new BusinessException(ExceptionEnum.GIVE_AWAY_ROOM_CARD_FAIL);
		}
	}

}
