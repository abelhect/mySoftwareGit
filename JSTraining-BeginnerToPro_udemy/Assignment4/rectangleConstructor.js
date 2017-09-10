//constructor function to represent a rectangle and can calculate its area 
//and perimeter
function Rectangle(length, width){
	// this.length = length;
	// this.width = width;
	this.area = function(){return length*width;};
	this.perimeter = function (){return 2*(length+width);};
}
	
var rectangle = new Rectangle(2,4);
rectangle.area
rectangle.perimeter