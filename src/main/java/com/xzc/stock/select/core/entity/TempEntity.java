package com.xzc.stock.select.core.entity;

public class TempEntity {

	private String start;
	private String end;
	private String low;
	private String high;
	private String date;
	private String volume;
	private String currVolume;
	private String prevVolume;
	private String aveVolume;
	
	public String getCurrVolume() {
		return currVolume;
	}
	public void setCurrVolume(String currVolume) {
		this.currVolume = currVolume;
	}
	public String getPrevVolume() {
		return prevVolume;
	}
	public void setPrevVolume(String prevVolume) {
		this.prevVolume = prevVolume;
	}
	public String getAveVolume() {
		return aveVolume;
	}
	public void setAveVolume(String aveVolume) {
		this.aveVolume = aveVolume;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	
}
