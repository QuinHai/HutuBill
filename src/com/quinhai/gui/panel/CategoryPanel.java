package com.quinhai.gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.hibernate.jdbc.WorkExecutor;

import com.quinhai.entity.Category;
import com.quinhai.gui.listener.CategoryListener;
import com.quinhai.gui.model.CategoryTableModel;
import com.quinhai.service.CategoryService;
import com.quinhai.util.ColorUtil;
import com.quinhai.util.GUIUtil;

public class CategoryPanel extends WorkingPanel {

	static {
		GUIUtil.useLNF();
	}
	public static CategoryPanel instance = new CategoryPanel();

	public JButton bAdd = new JButton("����");
	public JButton bEdit = new JButton("�༭");
	public JButton bDelete = new JButton("ɾ��");
	String columNames[] = new String[] { "��������", "���Ѵ���" };

	public CategoryTableModel ctm = new CategoryTableModel();
	public JTable t = new JTable(ctm);

	public CategoryPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete);
		JScrollPane sp = new JScrollPane(t);
		JPanel pSubmit = new JPanel();

		pSubmit.add(bAdd);
		pSubmit.add(bEdit);
		pSubmit.add(bDelete);

		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);
		
		addListener();
	}

	public Category getSelectedCategory() {
		int index = t.getSelectedRow();
		return ctm.cs.get(index);
	}

	public void updateData() {
		ctm.cs = new CategoryService().list();
		t.updateUI();
		t.getSelectionModel().setSelectionInterval(0, 0);

		if (0 == ctm.cs.size()) {
			bEdit.setEnabled(false);
			bDelete.setEnabled(false);
		} else {
			bEdit.setEnabled(true);
			bDelete.setEnabled(true);
		}
	}

	public void addListener() {
		CategoryListener listener = new CategoryListener();
		bAdd.addActionListener(listener);
		bEdit.addActionListener(listener);
		bDelete.addActionListener(listener);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.instance);
	}

}
