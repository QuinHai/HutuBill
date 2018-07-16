package com.quinhai.frame;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * 	JFrame��һ������Ŀ���࣬�ñ�һ�������Ŀ��ӡ�Ҳ��һ�������ࡣ������ӿ���Ƕ�뼸����������
	JPanel��һ�������࣬�൱��һ��������
	JLabel����һЩ�������������������ĳ������������ڴ�������ֽ���������ڴ����ı��档
 * 
 * */


public class MainFrame {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 400);
		f.setTitle("HuTuBill");
		// �������ô��������ָ�����λ�ã�null����������Ļ����
		f.setLocationRelativeTo(null);
		// �������ô����ܷ�����û�������С
		f.setResizable(false);
		// ����Ĭ�Ϲرն���
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar tb = new JToolBar();
		JButton bSpend = new JButton("����һ��");
		JButton bRecord = new JButton("��һ��");
		JButton bCategory = new JButton("���ѷ���");
		JButton bReport = new JButton("�����ѱ���");
		JButton bConfig = new JButton("����");
		JButton bBackup = new JButton("����");
		JButton bRecover = new JButton("�ָ�");

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
