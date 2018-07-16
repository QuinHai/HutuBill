package com.quinhai.gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;
import com.quinhai.entity.*;

import com.quinhai.dao.RecordDAO;
import com.quinhai.gui.page.SpendPage;
import com.quinhai.service.RecordService;
import com.quinhai.service.SpendService;
import com.quinhai.util.CircleProgressBar;
import com.quinhai.util.ColorUtil;
import com.quinhai.util.GUIUtil;

public class SpendPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}

	public static SpendPanel instance = new SpendPanel();

	JLabel lMonthSpend = new JLabel("��������");
	JLabel lTodaySpend = new JLabel("��������");
	JLabel lAvgSpendPerDay = new JLabel("�վ�����");
	JLabel lMonthLeft = new JLabel("����ʣ��");
	JLabel lDayAvgAvailable = new JLabel("�վ�����");
	JLabel lMonthLeftDay = new JLabel("������ĩ");

	JLabel vMonthSpend = new JLabel("��2300");
	JLabel vTodaySpend = new JLabel("��25");
	JLabel vAvgSpendPerDay = new JLabel("��120");
	JLabel vMonthAvailable = new JLabel("��2084");
	JLabel vDayAvgAvailable = new JLabel("��389");
	JLabel vMonthLeftDay = new JLabel("15��");

	CircleProgressBar bar;

	private SpendPanel() {
		this.setLayout(new BorderLayout());
//
//		SpendPage sp = new SpendService().getSpendPage();
//
//		vMonthSpend = new JLabel(sp.monthSpend);
//		vTodaySpend = new JLabel(sp.todaySpend);
//		vAvgSpendPerDay = new JLabel(sp.avgSpendPerDay);
//		vMonthAvailable = new JLabel(sp.monthAvailable);
//		vDayAvgAvailable = new JLabel(sp.dayAvgAvailable);
//		vMonthLeftDay = new JLabel(sp.monthLeftDay);

		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);

		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
				lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor, vMonthAvailable, vTodaySpend);

		vMonthSpend.setFont(new Font("΢���ź�", Font.BOLD, 45));
		vTodaySpend.setFont(new Font("΢���ź�", Font.BOLD, 45));

		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);

	}

	private JPanel center() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(west(), BorderLayout.WEST);
		p.add(center2(), BorderLayout.CENTER);

		return p;
	}

	private JPanel center2() {
		return bar;
	}

	private JPanel west() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		p.add(lMonthSpend);
		p.add(vMonthSpend);
		p.add(lTodaySpend);
		p.add(vTodaySpend);
		return p;
	}

	private JPanel south() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 4));

		p.add(lAvgSpendPerDay);
		p.add(lMonthLeft);
		p.add(lDayAvgAvailable);
		p.add(lMonthLeftDay);
		p.add(vAvgSpendPerDay);
		p.add(vMonthAvailable);
		p.add(vDayAvgAvailable);
		p.add(vMonthLeftDay);

		return p;
	}

	public static void main(String[] args) {

		GUIUtil.showPanel(SpendPanel.instance);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		SpendPage spend = new SpendService().getSpendPage();
        vMonthSpend.setText(spend.monthSpend);
        vTodaySpend.setText(spend.todaySpend);
        vAvgSpendPerDay.setText(spend.avgSpendPerDay);
        vMonthAvailable.setText(spend.monthAvailable);
        vDayAvgAvailable.setText(spend.dayAvgAvailable);
        vMonthLeftDay.setText(spend.monthLeftDay);
 
        bar.setProgress(spend.usagePercentage);
        if (spend.isOverSpend) {
            vMonthAvailable.setForeground(ColorUtil.warningColor);
            vMonthSpend.setForeground(ColorUtil.warningColor);
            vTodaySpend.setForeground(ColorUtil.warningColor);
 
        } else {
            vMonthAvailable.setForeground(ColorUtil.grayColor);
            vMonthSpend.setForeground(ColorUtil.blueColor);
            vTodaySpend.setForeground(ColorUtil.blueColor);
        }
        bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
        addListener();
	}
}
