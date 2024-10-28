package carRentalSystem;

import java.util.ArrayList;
import java.util.List;

import product.Car;
import product.Vehicle;
import product.VehicleType;

public class OfficialSite {

	public static void main(String[] args) {
		List<User> users = addUsers();
		List<Vehicle> vehicles = addVehicles();
		List<Store> stores = addStores(vehicles);
		VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);
		
		// Flow of Operations ---->

//		Step-1 User Comes to site
		User user = users.get(0);

//		 Step-2 User gets the store based on location
		Location location = new Location(403012, "Bangalore", "Karnataka", "India");
		Store store = rentalSystem.getStore(location);

//	     Step -3  List all the product which a store have
		List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

//	   Step -4 reserving the particular vehicle
		Reservation reservation = store.createReservation(storeVehicles.get(0), users.get(0));

//	   Step - 5 generate the bill
		Bill bill = new Bill(reservation);

//     Step-6 make payment
		Payment payment = new Payment();
		payment.payBill(bill);

//       Step -7 Complete the reservation
		store.completeReservation(reservation.reservationId);
	}

	public static List<Vehicle> addVehicles() {

		List<Vehicle> vehicles = new ArrayList<>();

		Vehicle vehicle1 = new Car();
		vehicle1.setVehicleID(1);
		vehicle1.setVehicleType(VehicleType.CAR);

		Vehicle vehicle2 = new Car();
		vehicle1.setVehicleID(2);
		vehicle1.setVehicleType(VehicleType.CAR);

		vehicles.add(vehicle1);
		vehicles.add(vehicle2);

		return vehicles;
	}

	public static List<User> addUsers() {

		List<User> users = new ArrayList<>();
		User user1 = new User();
		user1.setUserId(1);

		users.add(user1);
		return users;
	}

	public static List<Store> addStores(List<Vehicle> vehicles) {

		List<Store> stores = new ArrayList<>();
		Store store1 = new Store();
		store1.storeId = 1;
		store1.setVehicles(vehicles);

		stores.add(store1);
		return stores;
	}

}
