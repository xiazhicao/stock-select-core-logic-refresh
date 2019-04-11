package com.xzc.stock.select.core.entity;

public class EngineEntity {
	private float RSV ;
	private float CCI;	
	private float UP;
	private float DN;
	private float J;
	private float K;
	private float D;
	private float BIAS4;
	private float BIAS38;
	private float BIAS;
	
	private String name;
		
	private float low;
	private float high;
	private float end;
	private float md;
	private float ma10;
	private float ma9;
	private float tp;
	private float fiveAverage;
	private float averVolume;
	private float volume;
	private float distance;
	
	private String date;
	private String date4;
	private String date38;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getRSV() {
		return RSV;
	}
	public void setRSV(float rSV) {
		RSV = rSV;
	}
	public float getCCI() {
		return CCI;
	}
	public void setCCI(float cCI) {
		CCI = cCI;
	}
	public float getUP() {
		return UP;
	}
	public void setUP(float uP) {
		UP = uP;
	}
	public float getDN() {
		return DN;
	}
	public void setDN(float dN) {
		DN = dN;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getEnd() {
		return end;
	}
	public void setEnd(float end) {
		this.end = end;
	}
	public float getMd() {
		return md;
	}
	public void setMd(float md) {
		this.md = md;
	}
	public float getMa10() {
		return ma10;
	}
	public void setMa10(float ma10) {
		this.ma10 = ma10;
	}
	public float getMa9() {
		return ma9;
	}
	public void setMa9(float ma9) {
		this.ma9 = ma9;
	}
	public float getTp() {
		return tp;
	}
	public void setTp(float tp) {
		this.tp = tp;
	}
	public float getFiveAverage() {
		return fiveAverage;
	}
	public void setFiveAverage(float fiveAverage) {
		this.fiveAverage = fiveAverage;
	}
	public float getJ() {
		return J;
	}
	public void setJ(float j) {
		J = j;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getK() {
		return K;
	}
	public void setK(float k) {
		K = k;
	}
	public float getD() {
		return D;
	}
	public void setD(float d) {
		D = d;
	}
	public float getBIAS4() {
		return BIAS4;
	}
	public void setBIAS4(float bIAS4) {
		BIAS4 = bIAS4;
	}
	public float getBIAS38() {
		return BIAS38;
	}
	public void setBIAS38(float bIAS38) {
		BIAS38 = bIAS38;
	}
	public float getBIAS() {
		return BIAS;
	}
	public void setBIAS(float bIAS) {
		BIAS = bIAS;
	}
	public String getDate4() {
		return date4;
	}
	public void setDate4(String date4) {
		this.date4 = date4;
	}
	public String getDate38() {
		return date38;
	}
	public void setDate38(String date38) {
		this.date38 = date38;
	}
	public float getAverVolume() {
		return averVolume;
	}
	public void setAverVolume(float averVolume) {
		this.averVolume = averVolume;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
}
