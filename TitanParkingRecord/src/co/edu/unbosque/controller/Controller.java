package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;

import co.edu.unbosque.view.Add;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.Menu;

public class Controller implements MouseListener, ActionListener {

	private MainWindow mwin;

	public Controller() {
		mwin = new MainWindow();

		addReaders();
	}

	public void addReaders() {

		mwin.getMenu().getList().addMouseListener(this);

		mwin.getMenu().getDelete().addActionListener(this);
		mwin.getMenu().getDelete().setActionCommand("delete");

		mwin.getMenu().getShow().addActionListener(this);
		mwin.getMenu().getShow().setActionCommand("show");

		mwin.getMenu().getAddBtn().addActionListener(this);
		mwin.getMenu().getAddBtn().setActionCommand("addbtn");

		mwin.getAddPanel().getType().addActionListener(this);
		mwin.getAddPanel().getType().setActionCommand("type");

		mwin.getAddPanel().getBack().addActionListener(this);
		mwin.getAddPanel().getBack().setActionCommand("back");

		mwin.getAddPanel().getConfirm().addActionListener(this);
		mwin.getAddPanel().getConfirm().setActionCommand("confirm");
	}

	public void run() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "delete": {

			if (mwin.getMenu().getList().getSelectedValue() != null) {

				int aux = mwin.delete(0);

				if (aux == 0) {
					mwin.getMenu().getModel().remove(0);
					mwin.delete(1);
				} else {

					mwin.delete(2);
				}

			} else {

				mwin.delete(11);

			}

			break;
		}

		case "show": {

			if (mwin.getMenu().getList().getSelectedValue() != null) {

				// Aquí meter la lógica para mostrar el vehiculo de la lista | Ejemplo:

				LocalTime time = LocalTime.now();

				mwin.show("Car", "CBB-013", time);

			} else {

				mwin.delete(11);

			}

			break;
		}

		case "addbtn": {

			mwin.getMenu().setVisible(false);
			mwin.getAddPanel().setVisible(true);

			break;
		}

		case "type": {

			String aux = (String) mwin.getAddPanel().getType().getSelectedItem();

			switch (aux) {
			case "Null": {

				mwin.getAddPanel().getPlate().setEnabled(false);
				mwin.getAddPanel().getPlate().setBackground(Color.GRAY);
				mwin.getAddPanel().getPlate().setText("");

				break;

			}
			case "Car": {

				mwin.getAddPanel().getPlate().setEnabled(true);
				mwin.getAddPanel().getPlate().setBackground(Color.WHITE);

				break;

			}

			case "Motorcycle": {

				mwin.getAddPanel().getPlate().setEnabled(true);
				mwin.getAddPanel().getPlate().setBackground(Color.WHITE);

				break;

			}

			case "Bicycle": {

				mwin.getAddPanel().getPlate().setEnabled(false);
				mwin.getAddPanel().getPlate().setBackground(Color.GRAY);
				mwin.getAddPanel().getPlate().setText("");

				break;

			}

			case "Scooter": {

				mwin.getAddPanel().getPlate().setEnabled(false);
				mwin.getAddPanel().getPlate().setBackground(Color.GRAY);
				mwin.getAddPanel().getPlate().setText("");

				break;

			}

			default:
				break;
			}

			break;
		}

		case "back": {

			mwin.getMenu().setVisible(true);
			mwin.getAddPanel().setVisible(false);

			break;

		}

		case "confirm": {

			String aux = (String) mwin.getAddPanel().getType().getSelectedItem();

			if (aux.equals("Null")) {

				mwin.getAddPanel().warnings(0);
				break;

			}

			if (aux.equals("Car") || aux.equals("Motorcycle")) {

				if (mwin.getAddPanel().getPlate().getText().isEmpty()) {

					mwin.getAddPanel().warnings(2);

					break;

				}

			}

			if (!mwin.getAddPanel().getPlate().getText().isEmpty()) {

				mwin.getMenu().getModel().add(0, mwin.getAddPanel().getPlate().getText());
				mwin.getAddPanel().getPlate().setText("");
				mwin.getAddPanel().getType().setSelectedItem("Null");

			} else if (!aux.equals("Null")) {
				mwin.getMenu().getModel().add(0, aux);
				mwin.getAddPanel().getPlate().setText("");
				mwin.getAddPanel().getType().setSelectedItem("Null");

			}

			mwin.getMenu().setVisible(true);
			mwin.getAddPanel().setVisible(false);

			break;

		}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3) {

			mwin.getMenu().getPopUp().show(e.getComponent(), e.getX() + 10, e.getY());

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
