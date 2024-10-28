package carRentalSystem;

import java.util.ArrayList;
import java.util.List;

import product.Vehicle;
import product.VehicleType;

public class Store {
	int storeId;
	VehicleInventoryManagement inventoryManagement;
	Location storeLocation;
	List<Reservation> reservations = new ArrayList<>();

	// store related operations

//	    1)List all the products 
	public List<Vehicle> getVehicles(VehicleType vehicleType) {

		return inventoryManagement.getVehicles();
	}

//	    2) Provide facility to choose the product
	public void setVehicles(List<Vehicle> vehicles) {
		inventoryManagement = new VehicleInventoryManagement(vehicles);
	}

	public boolean completeReservation(int reservationID) {

		// take out the reservation from the list and call complete the reservation
		// method.
		return true;
	}

	public Reservation createReservation(Vehicle vehicle, User user) {
		Reservation reservation = new Reservation();
		reservation.createReserve(user, vehicle);
		reservations.add(reservation);
		return reservation;
	}

}
