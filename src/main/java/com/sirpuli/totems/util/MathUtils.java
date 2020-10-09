/*******************************************************************************
  Copyright 2020 Gergő Pauli
 ******************************************************************************/

package com.sirpuli.totems.util;

import java.util.Random;

@SuppressWarnings( "all" )
public class MathUtils{

	public static int randomIntInRange(int min, int max, Random rand){
		return rand.ints(min, max).findFirst().getAsInt();
	}

	public static double randomDoubleInRange(double min, double max, Random rand){
		return rand.doubles(min, max).findFirst().getAsDouble();
	}

	public static boolean betweenTwoNumber(int num, int low, int hight){
		if(num >=low && num <= hight) return true;
		return false;
	}
}
