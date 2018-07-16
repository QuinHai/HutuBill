package com.quinhai.util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.quinhai.gui.panel.WorkingPanel;

public class CenterPanel extends JPanel{
	private double rate;//�������
	private JComponent component;//��ʾ�����
	private boolean strech;//�Ƿ�����
	
	public CenterPanel(double rate, boolean strech) {
        this.setLayout(null);
		this.rate = rate;
		this.strech = strech;
	}
	
	public CenterPanel(double rate) {
		this(rate, true);
	}
	
	/*
	 *ʹ�þ��Զ�λ�ķ�ʽ����������м�λ��
	 * @see java.awt.Component#repaint()
	 */
	public void repaint() {
		if(component != null) {
			Dimension containerSize = this.getSize();
			Dimension componentSize = component.getPreferredSize();
			
			if(strech) {
				component.setSize((int)(containerSize.width * rate), (int)(containerSize.height * rate));
			}else {
				component.setSize(componentSize);
			}
		
		component.setLocation(containerSize.width / 2 - component.getSize().width / 2, containerSize.height / 2 - component.getSize().height / 2);
		}
		
		
		super.repaint();
	}
		
	public void show(JComponent p) {
		this.component = p;
		Component[] cs = getComponents();
		for(Component c : cs) {
			remove(c);
		}
		add(p);
		
        if (p instanceof WorkingPanel)
            ((WorkingPanel) p).updateData();
		
		this.updateUI();
	}
}
