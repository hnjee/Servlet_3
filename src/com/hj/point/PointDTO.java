package com.hj.point;

public class PointDTO {
	// DTO (Data Transfer Object)
	// VO (Value Object)
	
	// DTO 만드는 규칙  
	// 1. 변수의 접근제어자 private
	// 2. 변수의 Data Type과 변수명은 Table의 컬럼명과 일치시켜야함
	// 3. Getter / Setter 
	// 4. 생성자가 여러개 있어도 되지만 디폴트 생성자는 꼭 있어야함
	//    디폴트 생성자는 다른 생성자가 없으면 컴파일러가 자동으로 만들지만, 만약 다른 생성자를 만들면 자동으로 생성되지 않기 때문에 반드시 따로 만들어 놓을것 
 	
	private String name;
	private int num;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}
