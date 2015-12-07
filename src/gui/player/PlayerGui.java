package gui.player;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import player.IPlayer;
import player.Player;
import ships.IShip;

public class PlayerGui extends JComponent implements IPlayer{
	private static final long serialVersionUID = 1L;
	IPlayer _player = null;
	JLabel _lbl;

	public PlayerGui(String name, Color color){
		this(new Player(name, color));
	}
	
	public PlayerGui(IPlayer player){
		_player = player;
		_lbl = new JLabel(player.getName());

		this.setSize(100, 100);
		this.setBackground(player.getColor());
		this.add(_lbl);
	}
	
	public void setActive(boolean ActivePlayer){
		if (ActivePlayer)
			this.setBorder( BorderFactory.createLineBorder(Color.black));
		else
			this.setBorder(null);
		
		_lbl.setText(_player.getName() + " " + _player.warpedShips().length );  
	}
	
	@Override
	public String getName(){
		return _player.getName();
	}

	@Override
	public Color getColor() {
		return _player.getColor();
	}

	@Override
	public void setColor(Color color) {
		_player.setColor(color);
	}

	@Override
	public void setColor(String name) {
		_player.setColor(name);	
	}

	@Override
	public void Add(IShip ship) {
		_player.Add(ship);
	}

	@Override
	public IShip[] warpedShips() {
		return _player.warpedShips();
	}

	@Override
	public IShip[] getShips() {
		return _player.getShips();
	}

	@Override
	public void setShips(IShip[] ships) {
		_player.setShips(ships);
	}
}
