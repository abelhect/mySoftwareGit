//point function that takes x and y coordinates

function Point(a,b){
	var dx = ax - bx;
	var dy = ay - by;

	this.dist = function (){return Math.sqrt(dx * dx + dy * dy);};
}


	