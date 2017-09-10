function sum(){//user functional programming to add args
	var args = Array.prototype.slice.call(arguments);
	return args.reduce(function(prev, curr){
		if(!isNaN(curr)){	//warns user about non numberic args
			return prev + curr;
		}
		else{
			throw Error("Non-numberic argument: " + curr);
		}
	}, 0);
}

//catch errors link this to continue executing the code by using 
//try {} catch (error) {}
//example: try{
//				//function you want to catch error from here
//				}catch(error){
//				console.log(error);
//				}
