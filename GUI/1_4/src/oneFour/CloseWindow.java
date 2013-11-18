package oneFour;


import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class CloseWindow extends WindowAdapter
{
	Preferences prefs;
	Point wsize;
	Clock owner;

	public CloseWindow(Preferences prefs, Point wsize, Clock owner){
		this.prefs = prefs;
		this.wsize = wsize;
		this.owner = owner;
	}

	public void windowClosing(WindowEvent e){   //×を押されたときの処理
		try {
			prefs.putInt("windowPositonX", wsize.x);
			prefs.putInt("windowPositonY", wsize.y);
			prefs.flush();
			owner.intSave("windowPositonY", wsize.y);
			owner.intSave("windowPositonX", wsize.x);
			System.out.println("end  prefs.putInt(windowPositonX, wsize.x):" + owner.intLoad("windowPositonX", 0));
			System.out.println("end  prefs.putInt(windowPositonY, wsize.y):" + owner.intLoad("windowPositonY", 0));
			
		} catch (BackingStoreException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		System.exit(0);
		}
}