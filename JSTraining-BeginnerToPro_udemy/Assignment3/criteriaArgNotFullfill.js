//criteria function that takes elements as arguments or arrays and return boolean
	function strStartsWa(item){
			return (item.startsWith("a")) ? false : true;
	}

//function takes in an array
function criteriaArgNotFullfill(array, func){
	return array.filter(func);
}

var array = ["house", "avanico", "almohada", "avion", "chancleta"];

criteriaArgNotFullfill(array, strStartsWa)
	
