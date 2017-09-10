function is_integer(x) {
	
	if (typeof x == "number"){
		
		var xToString = x.toString();
		
		if (xToString.includes(".")) {

			return ("X is not an integer");

		} else {

			return ("X is an integer");

		}
	} else {

		return ("X is not a number.  Try again!");

		}
};