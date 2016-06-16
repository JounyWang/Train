package cn.train.entity;

/**
 * Train entity. @author MyEclipse Persistence Tools
 */

public class Train implements java.io.Serializable {

	// Fields

	private Integer trainNumber;
	private String trainNo;
	private String startStation;
	private String type;
	private String startTime;
	private String arrivalStation;
	private String mile;
	private String arrivalTime;
	private String runtime;

	// Constructors

	/** default constructor */
	public Train() {
	}

	/** full constructor */
	public Train(String trainNo, String startStation, String type,
			String startTime, String arrivalStation, String mile,
			String arrivalTime, String runtime) {
		this.trainNo = trainNo;
		this.startStation = startStation;
		this.type = type;
		this.startTime = startTime;
		this.arrivalStation = arrivalStation;
		this.mile = mile;
		this.arrivalTime = arrivalTime;
		this.runtime = runtime;
	}

	// Property accessors

	public Integer getTrainNumber() {
		return this.trainNumber;
	}

	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainNo() {
		return this.trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getStartStation() {
		return this.startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getArrivalStation() {
		return this.arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public String getMile() {
		return this.mile;
	}

	public void setMile(String mile) {
		this.mile = mile;
	}

	public String getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getRuntime() {
		return this.runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

}