
			var pictures = [];
			function load(){
				getPictures();
			}

			function getPictures(){
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.open("GET", "pictures.json", true); //to make this blocking use false otherwise always asyncronously with true.  THis is a network request and needs to be asyncronous
				xmlhttp.onload = function (event){

					//check status of http requests
					if(xmlhttp.status === 200){
						//fillup the array with the html URLs with the pictures
						pictures = JSON.parse(xmlhttp.responseText);
						changePic(0);//call the function that changes the pictures starting with first index
					}else if(xmlhttp.status === 401){
						alert("401 Unauthorized");
					}
				
				}
				xmlhttp.onerror = function (event) {
					alert("Ohh Ohh...  Something went wrong!");
				}	
				xmlhttp.send();
			}

			function fadeIn(el, time) {
			  el.style.opacity = 0;
			  el.style.display = "block";

			  var last = +new Date();
			  var tick = function() {
			    el.style.opacity = +el.style.opacity + (new Date() - last) / time;
			    last = +new Date();

			    if (+el.style.opacity < 1) {
			      (window.requestAnimationFrame && requestAnimationFrame(tick)) || setTimeout(tick, 16)
			    }
			  };

			  tick();
			}

			// function changePic(n){//function that changes the picture every 3 seconds.  The n parameter is the begining index for the pictures array
			// 	setInterval(function (){
			// 			document.getElementById("image_canvas").getElementsByTagName("img")[0].src = pictures[n++ % pictures.length];
			// 		},3000);

			//setTimeout function seems to bring firt picture quicker than setInterval function
			function changePic(n){//function that changes the picture every 5 seconds.  The n parameter is the begining index for the pictures array
				document.getElementById("image_canvas").getElementsByTagName("img")[0].src = pictures[n % pictures.length]; //using the % pictures.length so it starts at zero after last picture
				fadeIn(document.getElementById("image_canvas").getElementsByTagName("img")[0], 1000);
				setTimeout(function() {changePic(n+1);}, 5000);
			}

			
