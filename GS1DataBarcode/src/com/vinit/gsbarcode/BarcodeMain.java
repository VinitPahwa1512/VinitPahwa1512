package com.vinit.gsbarcode;


/***
 * 
 * @author pahwa
 *
 */
public class BarcodeMain {

	public BarcodeMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IGS1Databar d = new GS1Databar();
		System.out.println(d.parseGS1Databarcode("01073142280855071020345424020210442205021115000003620"));

	}

}
