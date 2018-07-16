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
				JOptionPane.showMessageDialog(p, "分类名称不能为空");
				return;
			}

			new CategoryService().add(name);
		}
		if (b == p.bEdit) {
			Category c = p.getSelectedCategory();
			int id = c.getId();
			String name = JOptionPane.showInputDialog("修改分类名称", c.getName());
			if(name == null) {
				return;
			}
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "分类名称不能为空");
				return;
			}

			new CategoryService().update(id, name);
		}
		if (b == p.bDelete) {
			Category c = p.getSelectedCategory();
			if (0 != c.getRecordNumber()) {
				JOptionPane.showMessageDialog(p, "本分类下有消费记录存在，不能删除");
				return;
			}
			if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确认要删除？"))
				return;

			int id = c.getId();
			new CategoryService().delete(id);
		}
		p.updateData();

	}

}
