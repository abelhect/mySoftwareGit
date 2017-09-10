function factorial_calc(number) {	
//if the number is not negative
	if (number >= 1) {

		var factorial = 1;

		do {
			factorial = factorial * number;
			number = number - 1;
		} while (number >= 1);

		return factorial;
		
	} else {
		return "Please give me a positive number greater than 0 to calculate factorial!"
	}

};