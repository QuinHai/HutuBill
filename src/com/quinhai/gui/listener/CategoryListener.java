package com.quinhai.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.quinhai.entity.Category;
import com.quinhai.gui.panel.CategoryPanel;
import com.quinhai.service.CategoryService;

public class CategoryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CategoryPanel p = CategoryPanel.instance;
		JButton b = (JButton) arg0.getSource();

		if (b == p.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			if(name == null) {
				return;
			}
			
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
				return;
			}

			new CategoryService().add(name);
		}
		if (b == p.bEdit) {
			Category c = p.getSelectedCategory();
			int id = c.getId();
			String name = JOptionPane.showInputDialog("�޸ķ�������", c.getName());
			if(name == null) {
				return;
			}
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
				return;
			}

			new CategoryService().update(id, name);
		}
		if (b == p.bDelete) {
			Category c = p.getSelectedCategory();
			if (0 != c.getRecordNumber()) {
				JOptionPane.showMessageDialog(p, "�������������Ѽ�¼���ڣ�����ɾ��");
				return;
			}
			if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "ȷ��Ҫɾ����"))
				return;

			int id = c.getId();
			new CategoryService().delete(id);
		}
		p.updateData();

	}

}
