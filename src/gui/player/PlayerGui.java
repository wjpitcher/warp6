package gui.player;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PlayerGui extends JPanel {
	player.Player _player = null;
	
	public PlayerGui(player.Player player){
		_player = player;
		this.setSize(100, 100);
		this.setBackground(player.getColor());
		this.add(new JLabel(player.getName()));
	}
	
	public void setActive(boolean ActivePlayer){
		if (ActivePlayer)
			this.setBorder( BorderFactory.createLineBorder(Color.black));
	}
	
}
