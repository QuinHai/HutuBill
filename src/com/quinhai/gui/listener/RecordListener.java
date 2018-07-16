package com.quinhai.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import com.quinhai.entity.Category;
import com.quinhai.entity.Record;
import com.quinhai.gui.panel.CategoryPanel;
import com.quinhai.gui.panel.MainPanel;
import com.quinhai.gui.panel.RecordPanel;
import com.quinhai.gui.panel.SpendPanel;
import com.quinhai.service.RecordService;
import com.quinhai.util.GUIUtil;

public class RecordListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		RecordPanel p = RecordPanel.instance;
		if (0 == p.cbModel.cs.size()) {
			JOptionPane.showMessageDialog(p, "�������ѷ��࣬�޷���ӣ������������ѷ���");
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}

		if (!GUIUtil.checkZero(p.tfSpend, "���ѽ��"))
			return;

		int spend = Integer.parseInt(p.tfSpend.getText());
		Category c = p.getSelectedCategory();
		String comment = p.tfComment.getText();
		Date d = p.datepick.getDate();
		new RecordService().add(spend, c, comment, d);
		JOptionPane.showMessageDialog(p, "��ӳɹ�");

		MainPanel.instance.workingPanel.show(SpendPanel.instance);
	}

}
