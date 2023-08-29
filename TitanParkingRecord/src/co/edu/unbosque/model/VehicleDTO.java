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

	public String getType() {
		return type;
	}

	public void setType(String tipe) {
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
				+ ((this.type.equals("Car") || this.type.equals("Motorcycle")) ? this.plate : "null plate") + "\n");
		sb.append("Entrance hour: " + this.entranceHour.toString().substring(0, 8) + "\n");

		return sb.toString();
	}

}
