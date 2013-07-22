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

	public CloseWindow(Preferences prefs, Point wsize){
		this.prefs = prefs;
		this.wsize = wsize;
	}

	public void windowClosing(WindowEvent e){   //×を押されたときの処理
		try {
			prefs.putInt("windowPositonX", wsize.x);
			prefs.putInt("windowPositonY", wsize.y);
			System.out.println("end  prefs.putInt(windowPositonX, wsize.x):" + wsize.x);
			System.out.println("end  prefs.putInt(windowPositonY, wsize.y):" + wsize.y);
			prefs.flush();
		} catch (BackingStoreException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		System.exit(0);
		}
}