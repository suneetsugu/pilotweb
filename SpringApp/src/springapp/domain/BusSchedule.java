package springapp.domain;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BUS_SCHEDULE")
public class BusSchedule 
{

	@Id
	@Column(name="id")
	private int id;  
	
	@Column(name="origin")
	  private String origin;
	
	@Column(name="destination")
	  private String destination;
	
	@Column(name="route")
	  private String route;
	
	@Column(name="bus_number")
	  private String busNumber;
	
	@Column(name="dep_time")
	  private Time depTime;
	
	@Column(name="arr_time")
	  private Time arrTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public Time getDepTime() {
		return depTime;
	}

	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}

	public Time getArrTime() {
		return arrTime;
	}

	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}
}

