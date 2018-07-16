package com.quinhai.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil {

	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if (text.length() == 0) {
			JOptionPane.showMessageDialog(null, input + "����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	public static boolean checkNumber(JTextField tf, String input) {
		if (!checkEmpty(tf, input))
			return false;
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, input + " ��Ҫ������");
			tf.grabFocus();
			return false;
		}
	}

	public static boolean checkZero(JTextField tf, String input) {
		if (!checkNumber(tf, input))
			return false;
		String text = tf.getText().trim();

		if (0 == Integer.parseInt(text)) {
			JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	/**
	 * ʹ��java�Դ���GUIƤ��
	 */
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}

	public static void setColor(Color color, JComponent... cs) {
		for (JComponent c : cs) {
			c.setForeground(color);
			// c.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		}
	}

	/**
	 * OLD
	 * 
	 * @param b
	 * @param fileName
	 * @param tip
	 */
	public static void setImageIcon(JButton b, String fileName, String tip) {
		String relativelyPath = System.getProperty("user.dir");
		String imageFolder = relativelyPath + "/img";

		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		b.setIcon(i);
		b.setPreferredSize(new Dimension(61, 81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);
	}

	/**
	 * NEW
	 * 
	 * @param b
	 * @param tip
	 */
	public static void setImageIcon(JButton b, String tip) {
		b.setText(tip);
		b.setPreferredSize(new Dimension(61, 81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
	}

	/**
	 * ���ڲ������
	 * 
	 * @param p
	 * @param strechRate
	 */
	public static void showPanel(JPanel p, double strechRate) {
		GUIUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(strechRate);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}

	public static void showPanel(JPanel p) {
		showPanel(p, 0.85);
	}

}
