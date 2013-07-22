package oneFour;

import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class MovedWindow extends ComponentAdapter {
	@SuppressWarnings("unused")
	private Point wsize;
	public MovedWindow(Point wsize){
		this.wsize = wsize;
	}

	public void componentMoved(ComponentEvent e){   //×を押されたときの処理
		wsize = null;
	}
}
