package co.edu.unbosque.model;

import co.edu.unbosque.model.persistance.FileHandler;

public class VehicleDAO implements OperationsDAO {

	MyDoubleLinkedList<VehicleDTO> vehiclesList;

	public VehicleDAO() {
//		vehiclesList = new MyDoubleLinkedList<VehicleDTO>();
		try {
			vehiclesList = (MyDoubleLinkedList<VehicleDTO>) FileHandler.readSerializable("vehicle.jzjm");
		} catch (Exception e) {
			vehiclesList = new MyDoubleLinkedList<VehicleDTO>();
		}
	}

	public MyDoubleLinkedList<VehicleDTO> getVehiclesList() {
		return vehiclesList;
	}

	public void setVehiclesList(MyDoubleLinkedList<VehicleDTO> vehiclesList) {
		this.vehiclesList = vehiclesList;
	}

	@Override
	public void add(Object o) {
		vehiclesList.insert((VehicleDTO) o);
		FileHandler.writeSerializable("vehicle.jzjm", vehiclesList);
	}

	@Override
	public boolean delete(int i) {

		try {
			vehiclesList.remove(i);
			FileHandler.writeSerializable("vehicle.jzjm", vehiclesList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public String show() {

		return vehiclesList.toString();

	}

}
