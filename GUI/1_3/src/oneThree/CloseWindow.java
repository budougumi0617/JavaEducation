/*
 * @file
 * @par File Name:
 * CloseWindow.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package oneThree;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseWindow extends WindowAdapter
{
    public void windowClosing(WindowEvent e){   //×を押されたときの処理
       System.exit(0);
    }
}