package gui.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

import player.IPlayer;
import player.Player;
import ships.IShip;

public class PlayerGui extends JComponent implements IPlayer{
	private static final long serialVersionUID = 1L;
	IPlayer _player = null;
	JLabel  _lbl;
	boolean _activePlayer = false;
	
	public PlayerGui(String name, Color color){
		this(new Player(name, color));
	}
	
	public PlayerGui(IPlayer player){
		_player = player;
		_lbl = new JLabel(player.getName());
		_lbl.setBackground(player.getColor());
		System.out.println(_lbl.getPreferredSize());
		this.setSize(100, 30);
		this.setPreferredSize(new Dimension(100, 30));
		this.setLayout(new FlowLayout());
		this.add(_lbl);
		this.setVisible(true);	
	}
	
	public void setActive(boolean ActivePlayer){
		if (ActivePlayer)
			this.setBorder( BorderFactory.createLineBorder(Color.black));
		else
			this.setBorder(null);
		
		_activePlayer = ActivePlayer;
		_lbl.setText(_player.getName() + " " + _player.warpedShips().length );  
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(_player.getColor());
		g.fillRect(0, 0, this.getWidth() -1, this.getHeight() - 1 );
		
		if (_activePlayer){
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, this.getWidth() -1, this.getHeight() - 1 );
		}
		
		super.paint(g);
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
