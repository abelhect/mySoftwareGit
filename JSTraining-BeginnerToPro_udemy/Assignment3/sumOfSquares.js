var array = [1, 2, 3];

function squareMap(num, index){
	return Math.pow(num, 2);
}

function sum(previous, current){
	return previous + current;
}

console.log(array.map(squareMap).reduce(sum));