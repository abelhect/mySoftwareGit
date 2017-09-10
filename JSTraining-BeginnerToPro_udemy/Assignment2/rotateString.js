function rotateString(x){
	var strToArray = x.split("");//var for string convert to array
	// var newArray = strToArray.pop().toString();//var for pop last element of array into a new array
	var answer = [];
	//iterate through the length of string
	for (i = 0; i < x.length; i++){	
		newArray = strToArray.pop().toString();
		answer.push(newArray);
	}
	return answer.toString().replace(/\,/g,"");
};



