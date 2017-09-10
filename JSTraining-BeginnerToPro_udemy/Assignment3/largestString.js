var array = ["otorinolariongologo", "casa", "camioneta", "camisa", "camiseta"];
function largestString(previous, current){
	return previous = (current.length > previous.length) ? current : previous;
};
console.log(array.reduce(largestString));