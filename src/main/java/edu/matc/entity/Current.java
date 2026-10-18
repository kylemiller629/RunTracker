
package edu.matc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Current {

	@JsonProperty("wind_speed_10m")
	private double windSpeed10m;

	@JsonProperty("temperature_2m")
	private double temperature2m;

	@JsonProperty("interval")
	private int interval;

	@JsonProperty("time")
	private String time;

	public void setWindSpeed10m(double windSpeed10m) {
		this.windSpeed10m = windSpeed10m;
	}

	public double getWindSpeed10m() {
		return windSpeed10m;
	}

	public void setTemperature2m(double temperature2m) {
		this.temperature2m = temperature2m;
	}

	public double getTemperature2m() {
		return temperature2m;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getInterval() {
		return interval;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}
}
