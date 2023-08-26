package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalTime;

public class VehicleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9160086447423958703L;
	private String type; // car or bike
	private String plate;
	private LocalTime entranceHour;

	public VehicleDTO() {
		// TODO Auto-generated constructor stub
	}

	public VehicleDTO(String tipe, String plate, LocalTime entranceHour) {
		super();
		this.type = tipe;
		this.plate = plate;
		this.entranceHour = entranceHour;
	}

	public String getTipe() {
		return type;
	}

	public void setTipe(String tipe) {
		this.type = tipe;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public LocalTime getEntranceHour() {
		return entranceHour;
	}

	public void setEntranceHour(LocalTime entranceHour) {
		this.entranceHour = entranceHour;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type of vehicle: " + this.type + "\n");
		sb.append("Plate of the vehicle: "
				+ ((this.type.equals("car") || this.type.equals("bike")) ? this.plate : "null plate") + "\n");
		sb.append("Entrance hour: " + this.entranceHour + "\n");

		return sb.toString();
	}

}
