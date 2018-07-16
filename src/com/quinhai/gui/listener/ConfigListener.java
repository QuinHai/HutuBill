package com.quinhai.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import com.quinhai.gui.panel.ConfigPanel;
import com.quinhai.service.ConfigService;
import com.quinhai.util.GUIUtil;

public class ConfigListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ConfigPanel p = ConfigPanel.instance;
		if (!GUIUtil.checkNumber(p.tfBudget, "本月预算"))
			return;
		String mysqlPath = p.tfMysqlPath.getText();
		if(mysqlPath == null) {
			return;
		}

		if (0 != mysqlPath.length()) {
			File commandFile = new File(mysqlPath, "bin/mysql.exe");
			if (!commandFile.exists()) {
				JOptionPane.showMessageDialog(p, "Mysql路径不正确");
				p.tfMysqlPath.grabFocus();
				return;
			}
		}
		
		ConfigService cs = new ConfigService();
		cs.update("budget", p.tfBudget.getText());
		cs.update("mysqlPath", mysqlPath);
		
		JOptionPane.showMessageDialog(p, "设置修改成功");
	}

}
