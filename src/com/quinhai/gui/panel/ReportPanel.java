package com.quinhai.gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.quinhai.entity.Record;
import com.quinhai.service.ReportService;
import com.quinhai.util.ChartUtil;
import com.quinhai.util.GUIUtil;

public class ReportPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}
	public static ReportPanel instance = new ReportPanel();

	public JLabel l = new JLabel();

	private ReportPanel() {
		this.setLayout(new BorderLayout());
		Image i = ChartUtil.getImage(400, 300);

		ImageIcon icon = new ImageIcon(i);
		l.setIcon(icon);
		this.add(l);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(ReportPanel.instance);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		List<Record> rs = new ReportService().listThisMonthRecords();
		Image i = ChartUtil.getImage(rs, 350, 250);
		ImageIcon icon = new ImageIcon(i);
		l.setIcon(icon);
	}

}
