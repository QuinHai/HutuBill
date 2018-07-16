package com.quinhai.startup;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import com.quinhai.gui.frame.MainFrame;
import com.quinhai.gui.panel.MainPanel;
import com.quinhai.gui.panel.SpendPanel;
import com.quinhai.util.GUIUtil;

public class Bootstrap {
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		GUIUtil.useLNF();
		
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				MainFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(SpendPanel.instance);
			}
		});
	}
}
