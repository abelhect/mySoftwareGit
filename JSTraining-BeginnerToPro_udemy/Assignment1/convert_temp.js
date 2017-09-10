function temp_convert(temp) {	
	//if string has C
	if (temp.includes('c')) {
		//convert string to number
		numberTemp = parseInt(temp);

		//grab the new string and use it in the formula
		//celcius to farhenheit
		var finalTemp = (9*numberTemp)/5 + 32;
		return finalTemp;
	}else if (temp.includes('f')){
		//convert string to number
		numberTemp = parseInt(temp);

		//farhenheit to celcius
		var finalTemp = ((numberTemp - 32))*(5/9);
		return finalTemp;
	}else {
		return 'use a string with C or F at the end for celcius or farhenheit. Example: "15C"'
		}

};