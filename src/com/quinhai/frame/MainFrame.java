package com.quinhai.frame;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * 	JFrame是一个顶层的框架类，好比一个窗户的框子。也是一个容器类。这个框子可以嵌入几个玻璃窗。
	JPanel是一个容器类，相当于一大玻璃窗。
	JLabel等是一些基础组件，它必须置于某个容器里，类似于窗花、剪纸，必须置于窗户的表面。
 * 
 * */


public class MainFrame {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 400);
		f.setTitle("HuTuBill");
		// 用于设置窗口相对于指定组件位置，null则将其置于屏幕中央
		f.setLocationRelativeTo(null);
		// 用于设置窗口能否可由用户调整大小
		f.setResizable(false);
		// 设置默认关闭动作
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar tb = new JToolBar();
		JButton bSpend = new JButton("消费一览");
		JButton bRecord = new JButton("记一笔");
		JButton bCategory = new JButton("消费分类");
		JButton bReport = new JButton("月消费报表");
		JButton bConfig = new JButton("设置");
		JButton bBackup = new JButton("备份");
		JButton bRecover = new JButton("恢复");

		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);

		f.setLayout(new BorderLayout());
		f.add(tb, BorderLayout.NORTH);
		f.add(new JPanel(), BorderLayout.CENTER);

		f.setVisible(true);

		bSpend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bRecover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

}
