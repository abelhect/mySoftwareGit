function ConstructApple(){
	console.log(this);

	this.color = "red";
	this.width = 200;
	this.height = 300;
}

ConstructApple.prototype = {
	eat: function(){return 'eat that apple';},
	throw: function(){return 'THROW IT';},
	nibble: function(){return 'nibble like a hamster';}
}

var apple = new ConstructApple();
var apple2 = new ConstructApple();
var apple3 = new ConstructApple();