/*
This is empty on purpose! Your code to build the resume will go here.
 */
//Practice how to append strings into the html page
//$("#main").append("Voyala Witi");

//Practice how to create my first variable and print
//on the chrome console
//var firstName = "Hector";
//var awesomeThoughts = "I am " + firstName + " and I am awesome!";
//console.log(awesomeThoughts);

//Practice how to replace parts of a string and print on console
//var email = "abelhect@hotmail.com";
//
//var newEmail = email.replace("hotmail", "gmail");
//
//console.log(email);
//console.log(newEmail);

//Practice how to replace a word in a string and show in the html page
//var funThoughts = awesomeThoughts.replace("awesome", "FUN");
//$("#main").append(funThoughts);

//Appending info to another js file
//var fullName = "Hector A. Martinez, P.E.";
//var role = "Technologist - Manager - Innovator";
//var formattedName = HTMLheaderName.replace("%data%", fullName);
//var formattedRole = HTMLheaderRole.replace("%data%", role);
//
//$("#header").append(formattedName);
//$("#header").append(formattedRole); 

var bio = {
	"name" : "Hector A. Martinez, P.E.", 
	"role" : "Technologist - Manager - Innovator",
	"contact" : "abelhect@hotmail.com", 
	"picture" : "images/me.jpg",
	"welcomeMsg" : "My experience and training as an engineer has opened my eyes about \
	the amazing opportunities to improve people’s lives and make a difference for \
	generations to come.  I’ve been fortunate to plan, design, test and administer systems \
	that are still in operation and bring real value to people."+ "<br><br>" + "Resource \
	(e.g. projects, people, and budgets) management has taught me the value and power of \
	strong soft skills.  Being able to partner and navigate through different professional \
	disciplines to deliver a system of products or processes has strengthen my value to \
	partners.  Optimization is one of my passions.  I am a firm believer in resourcefulness \
	and doing more with less.  I help my customers eliminate the waist, focus on what matters \
	most and achieve the best returns on investment."+ "<br><br>" + "Constant improvement is \
	my motto.  I aim to come up with ideas on a daily basis to help me be a better person and \
	professional.  My ability to relate to people of different cultures gives me a \
	comprehensive perspective about the world.  Being a fast learner and having the desire \
	to venture into new domains, new languages, and new skills enables me to deliberately \
	identify gaps."+ "<br><br>" +  "I am eager to meet \
	likeminded professionals such as yourself to help me expand my network, my \
	knowledge and exchange ideas. Don’t hesitate to contact me." + "<br><br>",
	"skills" : [" Project Management ", " Business Development ", 
	" Systems Engineering ", " Software Development "]
}

//var work = {}
//	work.employer = "MITRE Corporation";
//	work.currentJob = "Task Lead (Project Manager)";
//	work.yearsWorked = "1 Jan 2015 - Present";
//	work.city = "Tampa Florida";
//	work.pastEmployerOne = "MITRE Corporation";
//	work.pastJobOne = "Sr. Electrical Engineer";
//	work.pastYearsWorkedOne = "1 Oct 2012 - Present";
//	work.pastCityOne = "Tampa Florida";
//	work.pastEmployerTwo = "Concurrent Technologies Corporation";
//	work.pastJobTwo = "Sr. Communications Engineer";
//	work.pastYearsWorkedTwo = "1 Dec 2008 - 1 October 2012";
//	work.pastCityTwo = "Largo Florida";

	//In arrays should be better
//	work.employers = ["MITRE Corporation", "MITRE Corporation", "Concurrent Technologies Corporation"];
//	work.titles = ["Task Lead (Project Manager)", "Sr. Electrical Engineer", "Sr. Communications Engineer"];
//	work.years = ["1 Jan 2015 - Present", "1 Oct 2012 - Present", "1 Dec 2008 - 1 October 2012"];
//	work.cities = ["Tampa, FL", "Tampa, FL", "Largo, FL"];
//	work.descriptions = ["Manage the technical delivery and budget of command, control, communications \
//			and computer engineering services for the acquisition program office of our department of \
//			defense sponsor. Including the oversight of highly trained engineers supporting 5 different \
//			program of records yearly.",
//			"Aid my DoD sponsors with research, system engineering, system integration, and acquisition \
//			assessments. Provide business processes and technology improvement recommendations, testing, \
//			validation/verification of operational and developmental technologies. These technologies \
//			range from a variety of enterprise information technologies to specialized satellite systems \
//			and cyber security applications.",
//			"Hector joined the company as a mid-level engineer to support the research and development of \
//			communications systems for federal agencies. He was in charge of technology evaluation, system \
//			design, procurement, implementation, testing and validation.  During his years with the company, \
//			he developed into a senior engineer and technical lead in charge of identifying partnership \
//			opportunities in the search of new projects. He provided management support for projects between \
//			$150 thousand and $3 million worth in services and equipment."
//	                     ];
	
	//Another way to build the work array using JSON
	var work = {
			  "jobs": [
			    {
			      "employer": "MITRE Corporation",
			      "title": "Task Lead (Project Manager)",
			      "location": "Tampa, FL",
			      "dates": "1 Jan 2015 - Present",
			      "description": "Manage the technical delivery and budget of command, control, communications \
								and computer engineering services for the acquisition program office of our department of \
								defense sponsor. Including the oversight of highly trained engineers supporting 5 different \
								program of records yearly."
			    },
			    {
			      "employer": "MITRE Corporation",
			      "title": "Sr. Electrical Engineer",
			      "location": "Tampa, FL",
			      "dates": "1 Oct 2012 - Present",
			      "description": "Aid my DoD sponsors with research, system engineering, system integration, and acquisition \
								assessments. Provide business processes and technology improvement recommendations, testing, \
								validation/verification of operational and developmental technologies. These technologies \
								range from a variety of enterprise information technologies to specialized satellite systems \
								and cyber security applications."
			    },
			    {
			      "employer": "Concurrent Technologies Corporation",
			      "title": "Sr. Communications Engineer",
			      "location": "Largo, FL",
			      "dates": "1 Dec 2008 - 1 October 2012",
			      "description": "Joined the company as a junior engineer to support the research and development of \
								communications systems for federal agencies. He was in charge of technology evaluation, system \
								design, procurement, implementation, testing and validation.  During his years with the company, \
								he developed into a senior engineer and technical lead in charge of identifying partnership \
								opportunities in the search of new projects. He provided management support for projects between \
								$150 thousand and $3 million worth in services and equipment."
			    }
			  ]
			};

//Projects array using JSON
var project = {
		  "projects": [
		    {
		      "title": "Awesome Project Number Uno",
		      "dates": "1 Jan 2015 - Present",
		      "description": "The project was so awesome that i barely have words to describe it."
		    },
		    {
		    	"title": "Awesome Project Number Dos",
			    "dates": "1 Jan 2010 - 2015",
			    "description": "The project was so awesome that i barely have words to describe it."
		    }
		  ]
		};

//Using bracket notation to add properties to my education object
//var  education = {}
//	education["nameSchool"] = "Florida State University - College of Engineering";
//	education["years"] = "2004 - 2005";
//	education["degree"] = "M.S., Electrical Engineering";
//	education["city"] = "Tallahassee Florida";

//Now using JSON	
var education = {
		  "schools": [
		    {
		      "name": "Florida State University - College of Engineering",
		      "location": "Tallahassee, FL",
		      "degree": "Electrical Engineering",
		      "major": "Masters of Science",
		      "dates": "2004 - 2005"
		    },
		    {
		      "name": "Florida State University - College of Engineering",
		      "location": "Tallahassee, FL",
		      "degree": "Electrical Engineering",
		      "major": "Bachellors of Science",
		      "dates": "2000 - 2003"
		    }
		  ],
		  "onlineCourses":[
			{
				"name": "Udacity.com",
				"course": "JavaScript Basics",
				"dates": "2016"
			}
			]
		};


$("#header").append(HTMLheaderName.replace("%data%", bio.name), 
					HTMLheaderRole.replace("%data%", bio.role),
					HTMLemail.replace("%data%", bio.contact),
					HTMLbioPic.replace("%data%", bio.picture),
					HTMLwelcomeMsg.replace("%data%", bio.welcomeMsg));

//Trying to make the if statement work
if(bio.skills.length > 0){
	$("#header").append(HTMLskillsStart);

//Using For loop (4 lines of code)
	for(var i=0; i<=3; i++){
		var formattedSkills = HTMLskills.replace("%data%", bio.skills[i]);
		$("#skills").append(formattedSkills);
	}
	
//Using While Loop	(6 lines of code)
//	var i = 0;
//	while(i <= 3){
//		var formattedSkills = HTMLskills.replace("%data%", bio.skills[i]);
//		$("#skills").append(formattedSkills);
//		i++;
//	}

	//One by one sucks.  This is the long way to do it
//	$("#skills").append(formattedSkills);
//	formattedSkills = HTMLskills.replace("%data%", bio.skills[2]);
//	$("#skills").append(formattedSkills);
//	formattedSkills = HTMLskills.replace("%data%", bio.skills[3]);
//	$("#skills").append(formattedSkills);
}

//Appending the work object (works with the original work object
//$("#workExperience").append(
//							HTMLworkStart, HTMLworkEmployer.replace("%data%", work.employer),
//							HTMLworkTitle.replace("%data%", work.currentJob), HTMLworkDates.replace("%data%", work.yearsWorked),
//							HTMLworkLocation.replace("%data%", work.city)
//							);

//function displayWork() {
//	$("#workExperience").append(
//			HTMLworkStart, HTMLworkEmployer.replace("%data%", work.employers[0]),
//			HTMLworkTitle.replace("%data%", work.titles[0]), HTMLworkDates.replace("%data%", work.years[0]),
//			HTMLworkLocation.replace("%data%", work.cities[0]), HTMLworkDescription.replace("%data%", work.descriptions[0]),
//			HTMLworkEmployer.replace("%data%", work.employers[1]),
//			HTMLworkTitle.replace("%data%", work.titles[1]), HTMLworkDates.replace("%data%", work.years[1]),
//			HTMLworkLocation.replace("%data%", work.cities[1]), HTMLworkDescription.replace("%data%", work.descriptions[1]),
//			HTMLworkEmployer.replace("%data%", work.employers[2]),
//			HTMLworkTitle.replace("%data%", work.titles[2]), HTMLworkDates.replace("%data%", work.years[2]),
//			HTMLworkLocation.replace("%data%", work.cities[2]), HTMLworkDescription.replace("%data%", work.descriptions[2])
//			);
//}
//displayWork();

//Appending the work object using for-in loop
for (var key in work.jobs) {
	if (work.jobs.hasOwnProperty(key)){
	$("#workExperience").append(HTMLworkStart);
	var formattedEmployer = HTMLworkEmployer.replace("%data%", work.jobs[key].employer);
	var formattedTitle = HTMLworkTitle.replace("%data%", work.jobs[key].title);
	var formattedEmployerTitle = formattedEmployer + formattedTitle;
	$(".work-entry:last").append(formattedEmployerTitle);
	
	var formattedLocation = HTMLworkLocation.replace("%data%", work.jobs[key].location);
	$(".work-entry:last").append(formattedLocation);
	var formattedDates = HTMLworkDates.replace("%data%", work.jobs[key].dates);
	$(".work-entry:last").append(formattedDates);
	var formattedDescription = HTMLworkDescription.replace("%data%", work.jobs[key].description);
	$(".work-entry:last").append(formattedDescription);
	}
}

//Function to append Projects into the HTML
project.display = function(){
	for (key in project.projects){
		if (project.projects.hasOwnProperty(key)){
			$("#projects").append(HTMLprojectStart);
			var formattedTitle = HTMLprojectTitle.replace("%data%", project.projects[key].title);
			$(".project-entry:last").append(formattedTitle);
			var formattedDates = HTMLprojectDates.replace("%data%", project.projects[key].dates);
			$(".project-entry:last").append(formattedDates);
			var formattedDescription = HTMLprojectDescription.replace("%data%", project.projects[key].description);
			$(".project-entry:last").append(formattedDescription);
		}	
	}
}
project.display();


//This is using bracket notation
//$("#education").append(HTMLschoolStart, HTMLschoolName.replace("%data%", education["nameSchool"]),
//						HTMLschoolDegree.replace("%data%", education["degree"]), 
//						HTMLschoolDates.replace("%data%", education["years"]),
//						HTMLschoolLocation.replace("%data%", education["city"]));

//using Function display to populate education
education.display = function(){
	for (key in education.schools){
		if (education.schools.hasOwnProperty(key)){
			$("#education").append(HTMLschoolStart);
			var formattedName = HTMLschoolName.replace("%data%", education.schools[key].name);
			$(".education-entry:last").append(formattedName);
			var formattedDegree = HTMLschoolDegree.replace("%data%", education.schools[key].degree);
			$(".education-entry:last").append(formattedDegree);
			var formattedDates = HTMLschoolDates.replace("%data%", education.schools[key].dates);
			$(".education-entry:last").append(formattedDates);
			var formattedLocation = HTMLschoolLocation.replace("%data%", education.schools[key].location);
			$(".education-entry:last").append(formattedLocation);
			var formattedMajor = HTMLschoolMajor.replace("%data%", education.schools[key].major);
			$(".education-entry:last").append(formattedMajor);
		}
	}
}

education.display();

//Let's user JSON [it doesn't work though]
//$("#education").append(HTMLschoolStart, HTMLschoolName.replace("%data%", education.schools["name"]),
//						HTMLschoolDegree.replace("%data%", education.schools.degree), 
//						HTMLschoolDates.replace("%data%", education.schools.years),
//						HTMLschoolLocation.replace("%data%", education.schools.city));

//Function to internationalize the name
function inName(name) {
		newName = name.split(" ");
	newName = newName[0] + " " + newName[1] + " " + newName[2].toUpperCase() + " " + newName[3];	
	return newName;
}
//Appending the internationalized button to the main page
$("#main").append(internationalizeButton);

$("#mapDiv").append(googleMap);