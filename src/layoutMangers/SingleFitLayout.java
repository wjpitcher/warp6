package layoutMangers;
import java.awt.*;

import gui.board.NodeGui;

public class SingleFitLayout implements LayoutManager {

    private int _panelWidth = -1;
    private int _panelHeight = -1;
    
    public SingleFitLayout() {
        super();
    }
 
    /* Required by LayoutManager. */
    public void addLayoutComponent(String name, Component comp) {}
 
    /* Required by LayoutManager. */
    public void removeLayoutComponent(Component comp) {}
 
    private void setSizes(Container parent) {
        ResizeControl(parent, parent.getComponent(0));
    }

	private void ResizeControl(Container parent, Component component){
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		int compWidth = component.getPreferredSize().width;
		int compHeight = component.getPreferredSize().height;
		
		// Check verify the dimensions changed 
		if(_panelHeight != parent.getSize().height
		|| _panelWidth  != parent.getSize().width)
		{		
			_panelHeight = parent.getSize().height;
			_panelWidth  = parent.getSize().width;

			// determine the size of the board
			if(compWidth > compHeight){
				if (_panelWidth / _panelHeight
				 < compWidth /  compHeight){	
				    width = _panelWidth;
					x = 0;
					height = _panelWidth * compHeight / compWidth;
					y = (_panelHeight - height) / 2;
				}
				else{
					height = _panelHeight;
					y = 0; 
					width = _panelHeight * compWidth / compHeight;
					x = (_panelWidth - width) / 2;
				}
			}
			else{
				if (_panelWidth / _panelHeight
				  > compWidth /  compHeight){	
						width = _panelWidth;
						x = 0;
						height = _panelWidth * compHeight / compWidth;
						y = (_panelHeight - height) / 2;
					}
					else{
						height = _panelHeight;
						y = 0; 
						width = _panelHeight * compWidth / compHeight;
						x = (_panelWidth - width) / 2;
					}
			}
			
			component.setBounds(x, y, width, height);
		}
	}
    
    
    /* Required by LayoutManager. */
    public Dimension preferredLayoutSize(Container parent) {
    	
    	return new Dimension(0, 0);
    }
 
    /* Required by LayoutManager. */
    public Dimension minimumLayoutSize(Container parent) {
    	return new Dimension(0, 0);
    }
 
    /* Required by LayoutManager. */
    /*
     * This is called when the panel is first displayed,
     * and every time its size changes.
     * Note: You CAN'T assume preferredLayoutSize or
     * minimumLayoutSize will be called -- in the case
     * of applets, at least, they probably won't be.
     */
    public void layoutContainer(Container parent) {
    	if(parent.getComponents().length > 0 )
    		ResizeControl(parent, parent.getComponent(0));
    	else
    		setSizes(parent);   	    	
    }
 
    public String toString() {
        return getClass().getName() ;
    }
}
