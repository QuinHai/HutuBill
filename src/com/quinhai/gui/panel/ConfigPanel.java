package com.quinhai.gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.quinhai.gui.listener.ConfigListener;
import com.quinhai.service.ConfigService;
import com.quinhai.util.ColorUtil;
import com.quinhai.util.GUIUtil;

public class ConfigPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}

	public static ConfigPanel instance = new ConfigPanel();

	JLabel lBudget = new JLabel("本月预算(￥)");
	public JTextField tfBudget = new JTextField("0");

	JLabel lMysql = new JLabel("Mysql安装目录");
	public JTextField tfMysqlPath = new JTextField("");

	JButton bSubmit = new JButton("更新");

	private ConfigPanel() {
		this.setLayout(new BorderLayout());

		GUIUtil.setColor(ColorUtil.grayColor, lBudget, lMysql);
		GUIUtil.setColor(ColorUtil.blueColor, bSubmit);

		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;

		pInput.setLayout(new GridLayout(4, 1, gap, gap));

		pInput.add(lBudget);
		pInput.add(tfBudget);
		pInput.add(lMysql);
		pInput.add(tfMysqlPath);
		this.add(pInput, BorderLayout.NORTH);

		pSubmit.add(bSubmit);
		this.add(pSubmit, BorderLayout.SOUTH);

		addListener();
	}

	public void addListener() {
		ConfigListener l = new ConfigListener();
		bSubmit.addActionListener(l);
	}

	@Override
	public void updateData() {
		String budget = new ConfigService().get("budget");
		String mysqlPath = new ConfigService().get("mysqlPath");
		tfBudget.setText(budget);
		tfMysqlPath.setText(mysqlPath);
		tfBudget.grabFocus();
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(ConfigPanel.instance);
	}

}
