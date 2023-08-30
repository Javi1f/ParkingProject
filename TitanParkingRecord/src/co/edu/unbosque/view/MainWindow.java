package co.edu.unbosque.view;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.time.LocalTime;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

public class MainWindow extends JFrame {

	private Add addPanel;
	private Menu menu;
	private Dimension size;

	public MainWindow() {

		addPanel = new Add();
		menu = new Menu();

		size = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((size.width / 2) - 400, (size.height / 2) - 300, 800, 600);
		setTitle("Titan plaza parking");
		ImageIcon icon = new ImageIcon("src/Assets/icon.png");
		setIconImage(icon.getImage());
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(menu);
		add(addPanel);

		setVisible(true);

	}

	public Add getAddPanel() {
		return addPanel;
	}

	public void setAddPanel(Add addPanel) {
		this.addPanel = addPanel;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public int delete(int i) {

		if (i == 0) {
			int aux = JOptionPane.showConfirmDialog(null, "Are you sure to PERMANENTLY delete the selected vehicle?");
			return aux;
		}

		else if (i == 11) {

			JOptionPane.showMessageDialog(null,
					"A valid item has not been selected, please select a vehicle from the list and try again");

		}

		else if (i == 1) {

			JOptionPane.showMessageDialog(null, "The vehicle has been successfully removed");

		} else {

			JOptionPane.showMessageDialog(null, "the vehicle was NOT removed");

		}

		return 69;
	}

	public void show(String text) {

		JOptionPane.showMessageDialog(null, text);

	}

}
