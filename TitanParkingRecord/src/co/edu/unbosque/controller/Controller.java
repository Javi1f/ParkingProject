package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;

import co.edu.unbosque.model.MyDoubleLinkedList;
import co.edu.unbosque.model.VehicleDAO;
import co.edu.unbosque.model.VehicleDTO;
import co.edu.unbosque.view.MainWindow;

public class Controller implements MouseListener, ActionListener {

	private MainWindow mwin;
	private VehicleDAO vdao;
	private MyDoubleLinkedList<VehicleDTO> exitVehicleList;
	private boolean listSwitch;

	public Controller() {
		mwin = new MainWindow();
		vdao = new VehicleDAO();
		exitVehicleList = new MyDoubleLinkedList<VehicleDTO>();
		listSwitch = true;
		chargeModel();
		addReaders();
	}

	public void addReaders() {

		mwin.getMenu().getList().addMouseListener(this);

		mwin.getMenu().getDelete().addActionListener(this);
		mwin.getMenu().getDelete().setActionCommand("delete");

		mwin.getMenu().getShow().addActionListener(this);
		mwin.getMenu().getShow().setActionCommand("show");

		mwin.getMenu().getSwitchList().addActionListener(this);
		mwin.getMenu().getSwitchList().setActionCommand("switch");

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

	public void chargeEspecialModel() {
		mwin.getMenu().getModel().clear();
		for (int i = 0; i < exitVehicleList.size(); i++) {
			if (exitVehicleList.get(i).getType().equals("Car")
					|| exitVehicleList.get(i).getType().equals("Motorcycle")) {
				mwin.getMenu().getModel().addElement("DELETED: " + exitVehicleList.get(i).getPlate());
			} else {
				mwin.getMenu().getModel().addElement("DELETED: " + exitVehicleList.get(i).getType());
			}
		}
	}

	public void chargeModel() {
		mwin.getMenu().getModel().clear();
		for (int i = 1; i < vdao.getVehiclesList().size(); i++) {

			if (vdao.getVehiclesList().get(i).getType().equals("Car")
					|| vdao.getVehiclesList().get(i).getType().equals("Motorcycle")) {
				mwin.getMenu().getModel().addElement(vdao.getVehiclesList().get(i).getPlate());

			} else {
				mwin.getMenu().getModel().addElement(vdao.getVehiclesList().get(i).getType());
			}
		}
	}

	public void chargeModelFromZero() {
		mwin.getMenu().getModel().clear();
		for (int i = 0; i < vdao.getVehiclesList().size(); i++) {

			if (vdao.getVehiclesList().get(i).getType().equals("Car")
					|| vdao.getVehiclesList().get(i).getType().equals("Motorcycle")) {
				mwin.getMenu().getModel().addElement(vdao.getVehiclesList().get(i).getPlate());

			} else {
				mwin.getMenu().getModel().addElement(vdao.getVehiclesList().get(i).getType());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "switch": {
			if (listSwitch) {
				chargeEspecialModel();
				listSwitch = false;
			} else {
				chargeModel();
				listSwitch = true;
			}
			break;
		}
		case "delete": {

			if (listSwitch) {
				if (mwin.getMenu().getList().getSelectedValue() != null) {

					int aux = mwin.delete(0);

					if (aux == 0) {

						int index = mwin.getMenu().getList().getSelectedIndex();
						exitVehicleList.insert(vdao.getVehiclesList().get(index + 1));
						System.out.println(exitVehicleList.toString());
						vdao.delete(index + 1);
						mwin.getMenu().getModel().remove(index);
						mwin.delete(1);

					} else {

						mwin.delete(2);
					}

				} else {

					mwin.delete(11);

				}
			} else {
				mwin.show("It is not possible to delete vehicles that have already been deleted");
			}

			break;
		}

		case "show": {

			if (listSwitch) {

				if (mwin.getMenu().getList().getSelectedValue() != null) {
					mwin.show(vdao.getVehiclesList().get(mwin.getMenu().getList().getSelectedIndex() + 1).toString());

				} else {

					mwin.delete(11);

				}
			} else {
				if (mwin.getMenu().getList().getSelectedValue() != null) {
					mwin.show(exitVehicleList.get(mwin.getMenu().getList().getSelectedIndex()).toString());

				} else {

					mwin.delete(11);

				}
			}

			break;
		}

		case "addbtn": {

			if (listSwitch) {
				if (!(vdao.getVehiclesList().size() >= 100)) {
					mwin.getMenu().setVisible(false);
					mwin.getAddPanel().setVisible(true);
				} else {
					mwin.show("We can´t accept more vehicles now, come back later...");
				}
			} else {
				mwin.show("first change the list to add correctly");
			}

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
			LocalTime tempTime = LocalTime.now();

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
				chargeModelFromZero();
				vdao.add(new VehicleDTO(aux, mwin.getAddPanel().getPlate().getText(), tempTime));
				chargeModel();
				mwin.getAddPanel().getPlate().setText("");
				mwin.getAddPanel().getType().setSelectedItem("Null");

			} else if (!aux.equals("Null")) {
				chargeModelFromZero();
				vdao.add(new VehicleDTO(aux, "null", tempTime));
				chargeModel();
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
