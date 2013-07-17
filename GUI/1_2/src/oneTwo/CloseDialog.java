/*
 * @file
 * @par File Name:
 * CloackDialog.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package oneTwo;


import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseDialog extends WindowAdapter
{
	private Dialog dlg;

	/**
	 * コンストラクタ
	 * @param dlg ダイアログ変数
	 */
	public CloseDialog(Dialog dlg){
		this.dlg = dlg;
	}
	/**
	 * 閉じるボタンが押されたときの処理
	 * ダイアログを非表示にする。
	 */
    public void windowClosing(WindowEvent e){
    	this.dlg.setVisible(false);
    	//this.dlg.dispose();
    	/*
    	Dialog test  = new Dialog(dlg, "foo", false);
    	test.setSize(100, 100);
    	test.setVisible(true);
    	*/
    }
}
