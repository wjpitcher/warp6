package layoutMangers;
import java.awt.*;

import gui.NodeGui;

public class SingleFitLayout implements LayoutManager {
    private int vgap;
    private int minWidth = 0, minHeight = 0;
    private int preferredWidth = 0, preferredHeight = 0;
    private boolean sizeUnknown = true;
 
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
    	
   /*
        Dimension dim = new Dimension(0, 0);
        int nComps = parent.getComponentCount();
 
        setSizes(parent);
 
        // Add container's insets!
        Insets insets = parent.getInsets();
        dim.width = preferredWidth
                    + insets.left + insets.right;
        dim.height = preferredHeight
                     + insets.top + insets.bottom;
 
        sizeUnknown = false;
 
        return dim;
        */
    	
    	return new Dimension(0, 0);
    }
 
    /* Required by LayoutManager. */
    public Dimension minimumLayoutSize(Container parent) {
/*
	    	Dimension dim = new Dimension(0, 0);
	 
	        //Always add the container's insets!
	        Insets insets = parent.getInsets();
	        dim.width = minWidth
	                    + insets.left + insets.right;
	        dim.height = minHeight
	                     + insets.top + insets.bottom;
	 
	        sizeUnknown = false;
	 
	        return dim;
	        */
    	
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
    	
/*
  	        Insets insets = parent.getInsets();
 
	        int maxWidth = parent.getWidth()
	                       - (insets.left + insets.right);
	        int maxHeight = parent.getHeight()
	                        - (insets.top + insets.bottom);
	        int nComps = parent.getComponentCount();
	        int previousWidth = 0, previousHeight = 0;
	        int x = 0, y = insets.top;
	        int rowh = 0, start = 0;
	        int xFudge = 0, yFudge = 0;
	        boolean oneColumn = false;
	 
	        // Go through the components' sizes, if neither
	        // preferredLayoutSize nor minimumLayoutSize has
	        // been called.
	        if (sizeUnknown) {
	            setSizes(parent);
	        }
	 
	        if (maxWidth <= minWidth) {
	            oneColumn = true;
	        }
	 
	        if (maxWidth != preferredWidth) {
	            xFudge = (maxWidth - preferredWidth)/(nComps - 1);
	        }
	 
	        if (maxHeight > preferredHeight) {
	            yFudge = (maxHeight - preferredHeight)/(nComps - 1);
	        }
	 
	        for (int i = 0 ; i < nComps ; i++) {
	            Component c = parent.getComponent(i);
	            if (c.isVisible()) {
	                Dimension d = c.getPreferredSize();
	 
	                 // increase x and y, if appropriate
	                if (i > 0) {
	                    if (!oneColumn) {
	                        x += previousWidth/2 + xFudge;
	                    }
	                    y += previousHeight + vgap + yFudge;
	                }
	 
	                // If x is too large,
	                if ((!oneColumn) &&
	                    (x + d.width) >
	                    (parent.getWidth() - insets.right)) {
	                    // reduce x to a reasonable number.
	                    x = parent.getWidth()
	                        - insets.bottom - d.width;
	                }
	 
	                // If y is too large,
	                if ((y + d.height)
	                    > (parent.getHeight() - insets.bottom)) {
	                    // do nothing.
	                    // Another choice would be to do what we do to x.
	                }
	 
	                // Set the component's size and position.
	                c.setBounds(x, y, d.width, d.height);
	 
	                previousWidth = d.width;
	                previousHeight = d.height;
	            }
	        }
	        */
    	    	
    }
 
    public String toString() {
        return getClass().getName() ;
    }
}
