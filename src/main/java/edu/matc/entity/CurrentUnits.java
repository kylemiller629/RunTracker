package edu.matc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentUnits{

	@JsonProperty("wind_speed_10m")
	private String windSpeed10m;

	@JsonProperty("temperature_2m")
	private String temperature2m;

	@JsonProperty("interval")
	private String interval;

	@JsonProperty("time")
	private String time;

	public void setWindSpeed10m(String windSpeed10m){
		this.windSpeed10m = windSpeed10m;
	}

	public String getWindSpeed10m(){
		return windSpeed10m;
	}

	public void setTemperature2m(String temperature2m){
		this.temperature2m = temperature2m;
	}

	public String getTemperature2m(){
		return temperature2m;
	}

	public void setInterval(String interval){
		this.interval = interval;
	}

	public String getInterval(){
		return interval;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}
}