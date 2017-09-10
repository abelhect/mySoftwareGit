function convert_to_coins(number) {	
	//initiate variables
	var cents25 = "25 ";//25 cents coins to print in console
	var cents10 = "10 ";//10 cents coins to print in console
	var cents5 = "5 ";//5 cents coins to print in console
	var cents2 = "2 ";//2 cents coins to print in console
	var cents1 = "1 ";//1 cents coins to print in console

//first calculate how many 25 cents included
	var num25s = parseInt(number / 25);//number of 25s = number / 25 (grab only the integer)
	
//then calculate remainder to find the 10s	
	var added25s = num25s * 25;//added 25s = number of 25s x 25
	
	var remain25 = number - added25s;//25remainder from main number = number - added 25s
	
	if (remain25 == 0) {
		return cents25.repeat(num25s);//if remainder = 0 then return the amount of 25 cents coins
	} else {
		
		var num10s = parseInt(remain25 / 10);//number of 10s = 25remainder from main number / 10 (grab only the integer)
		
	//then calculate remainder to find the 5s
		var added10s = num10s * 10;//added 10s = number of 10s x 10

		var remain10 = number - added25s - added10s;//10remainder from main number = number - added 25s - added 10s
		
		if (remain10 == 0) {
			return cents25.repeat(num25s) + cents10.repeat(num10s);//if remainder = 0 then 
																	//print the amount of 25 and 10 cent coins
		} else {

			var num5s = parseInt(remain10 / 5);//number of 5s = 10remainder from main number / 5 (grab only the integer)
			
		//then calculate remainder to find the 2s
			var added5s = num5s * 5;//added 5s = number of 5s x 5
			
			var remain5 = number - added25s - added10s - added5s;//5remainder from main number = number - added 25s - added 10s - added 5s
			
			if (remain5 == 0) {
				return cents25.repeat(num25s) + cents10.repeat(num10s) + cents5.repeat(num5s);//if remainder = 0 then 
																//print the amount of 25, 10 and 5 cent coins
			} else {
				var num2s = parseInt(remain5 / 2);//number of 2s = 5remainder from main number / 2 (need to grab only the integer)				

			//then calculate remainder to find the 1s
				var added2s = num2s * 2;//added 2s = number of 2s x 2
				
				var remain2 = number - added25s - added10s - added5s - added2s;//2remainder from main number = number - added 25s - added 10s - added 5s - added 2s

				if (remain2 == 0) {
					return cents25.repeat(num25s) + cents10.repeat(num10s) + cents5.repeat(num5s) + cents2.repeat(num2s);//if remainder = 0 then 
																	//print the amount of 25, 10, 5 and 2 cent coins
				} else {
									
				var num1s = parseInt(remain2 / 1);//number of 1s = 2remainder from main number / 1 (grab only the integer)
				
				return cents25.repeat(num25s) + cents10.repeat(num10s) + cents5.repeat(num5s) + cents2.repeat(num2s) + cents1.repeat(num1s);//if remainder = 0 then 
																	//print the amount of 25, 10, 5, 2 and 1 cent coins
				}
			}		
		}
	}
};