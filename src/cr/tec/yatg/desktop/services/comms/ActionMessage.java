package cr.tec.yatg.desktop.services.comms;

/**
 * Created by joseph on 29/09/16.
 */
public class ActionMessage {
	private Player player;
	private Action action;

	public void ActionMessage(Player player, Action action) {
		this.player = player;
		this.action = action;
	}
}
