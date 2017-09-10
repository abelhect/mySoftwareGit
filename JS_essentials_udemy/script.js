//the first variable is the box (i.e. html div) that holds 
//the options for square image styles
var arraySelect = document.getElementsByTagName('select');

//the second variable is the box (i.e. html div) that holds
//the actual square image
var element = document.getElementById('content');

//this function pretty much changes the styles
//it assignes the id (i.e. type of style like background color) 
//to a variable named style
//then it assigns the value of that style to variable value
//then it does the change in the box holding the square image
function dropdownStyles(){

var style = this.id;
var value = this.value;

element.style[style] = value;

}

//we are:
//iterating each item in the array starting with item background coler
//starting with array item background color i=0 up to array item height i=2
//it executes whats inside the for loop and then adds 1 to i
for (var i = 0; i < arraySelect.length; i++) {

	//when array item is background, i=0, add an event called 'change'
	//and perform the function dropdownStyles
	//NOTE: dont add the () next to the function ( i.e. dropdownStyles() ) 
	//when you are adding
	//the event listener because you will execute the function.	
	arraySelect[i].addEventListener('change', dropdownStyles);
	
}