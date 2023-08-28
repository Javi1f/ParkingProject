package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Add extends JPanel {

	private JPanel info, p1;
	private JLabel background, infoplate, infotype;
	private JTextField plate;
	private JComboBox<String> type;
	private DefaultListCellRenderer dlr;
	private JButton confirm, back;

	public Add() {
		setBounds(0, 0, 800, 600);
		setLayout(null);

		background = new JLabel();
		background.setBounds(0, 0, 785, 565);
		ImageIcon background2 = new ImageIcon("src/Assets/backgroundadd.jpg");
		background.setIcon(new ImageIcon(background2.getImage().getScaledInstance(785, 580, Image.SCALE_SMOOTH)));

		p1 = new JPanel();
		p1.setBounds(0, 0, 800, 600);
		p1.setLayout(null);

		info = new JPanel();
		info.setBounds(400 - (500 / 2), 300 - (200 / 2) - 40 + 10, 500, 200);
		info.setLayout(new GridLayout(0, 1));
		info.setOpaque(false);

		infotype = new JLabel("Please select the type of vehicle you wish to register");
		infotype.setHorizontalAlignment(SwingConstants.CENTER);

		infoplate = new JLabel("If the vehicle has a license plate, register it below");
		infoplate.setHorizontalAlignment(SwingConstants.CENTER);

		String[] types = { "Null", "Car", "Motorcycle", "Bicycle", "Scooter" };
		type = new JComboBox<String>(types);
		dlr = new DefaultListCellRenderer();
		dlr.setHorizontalAlignment(SwingConstants.CENTER);
		type.setRenderer(dlr);

		plate = new JTextField();
		plate.setBackground(Color.WHITE);
		plate.setHorizontalAlignment(SwingConstants.CENTER);
		plate.setEnabled(false);
		plate.setBackground(Color.GRAY);

		confirm = new JButton();
		confirm.setBounds(400 - (120 / 2) - 10, 440, 120, 60);
		ImageIcon addbt = new ImageIcon("src/Assets/confirm.png");
		confirm.setIcon(new ImageIcon(addbt.getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH)));
		confirm.setOpaque(false);
		confirm.setBorderPainted(false);
		confirm.setContentAreaFilled(false);
		confirm.setFocusPainted(false);

		back = new JButton();
		back.setBounds(80, 90, 80, 40);
		ImageIcon backbt = new ImageIcon("src/Assets/backbutton.png");
		back.setIcon(new ImageIcon(backbt.getImage().getScaledInstance(80, 40, Image.SCALE_SMOOTH)));
		back.setOpaque(false);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);

		add(confirm);
		add(back);
		info.add(infotype);
		info.add(type);
		info.add(infoplate);
		info.add(plate);
		add(info);
		p1.add(background);
		add(p1);

		setVisible(false);
	}

	public JPanel getInfo() {
		return info;
	}

	public void setInfo(JPanel info) {
		this.info = info;
	}

	public JPanel getP1() {
		return p1;
	}

	public void setP1(JPanel p1) {
		this.p1 = p1;
	}

	public void setBackground(JLabel background) {
		this.background = background;
	}

	public JLabel getInfoplate() {
		return infoplate;
	}

	public void setInfoplate(JLabel infoplate) {
		this.infoplate = infoplate;
	}

	public JLabel getInfotype() {
		return infotype;
	}

	public void setInfotype(JLabel infotype) {
		this.infotype = infotype;
	}

	public JTextField getPlate() {
		return plate;
	}

	public void setPlate(JTextField plate) {
		this.plate = plate;
	}

	public JComboBox<String> getType() {
		return type;
	}

	public void setType(JComboBox<String> type) {
		this.type = type;
	}

	public DefaultListCellRenderer getDlr() {
		return dlr;
	}

	public void setDlr(DefaultListCellRenderer dlr) {
		this.dlr = dlr;
	}

	public JButton getConfirm() {
		return confirm;
	}

	public void setConfirm(JButton confirm) {
		this.confirm = confirm;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public void warnings(int i) {

		// Excepcion de vehiculo no seleccionado
		if (i == 0) {
			JOptionPane.showMessageDialog(null,
					"Please select a type of vehicle to register before confirming the entry");
		}

		// Excepcion de placa no ingresada
		if (i == 2) {
			JOptionPane.showMessageDialog(null,
					"In the event that the vehicle is a car or a motorcycle, please include the license plate to register it");
		}

	}

}
