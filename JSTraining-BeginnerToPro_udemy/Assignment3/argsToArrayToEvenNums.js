	function argToArray(){
		var args = Array.prototype.slice.call(arguments);
		return args;
	}

	function evenNum(item){
		return item % 2 == 0;
	}

	argToArray(1,2,3,4,5,9,10).filter(evenNum);

