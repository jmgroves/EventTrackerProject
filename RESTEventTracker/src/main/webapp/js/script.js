var table = document.createElement('table');


window.addEventListener('load', function(e){
	console.log("locked and loaded");
	
	displayAllEvents()
	
	
	btn = document.getElementById('submit');
	
	btn.addEventListener('click', function(e){
		e.preventDefault();
		postEvent();
		
	});
	
});

function displayAllEvents(){
	 var xhr = new XMLHttpRequest();
	    xhr.open('GET', 'api/mileages', true);
	    	
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState === 4 && xhr.status < 400) {
	            var data = JSON.parse(xhr.responseText);
	            console.log(data);
	            displayEvents(data);
	            displayMpg();
	        }

	        if (xhr.readyState === 4 && xhr.status >= 400) {
	            console.error(xhr.status + ': ' + xhr.responseText);
	            var dataDiv = document.getElementById('eventDiv');
	            dataDiv.textContent = 'Event not found';

	        }
	    };

	    xhr.send(null);

	}



function displayEvents(events){
	var eventDiv = document.getElementById('eventDiv');
	eventDiv.textContent = "";
	
	
	table.id = 'table';
	table.name = 'table'
	table.textContent =  '';
	var th = document.createElement('th');
	
	events.forEach(function(event){
		var tr = document.createElement('tr');
		
		tr.addEventListener('click', function(e){
			e.preventDefault();
			var myForm = document.createElement('form');
			myForm.id = 'edit';
			var editDiv = document.getElementById('editDiv')
			editDiv.textContent = '';
			
			var in1 = document.createElement('input');
			in1.value = event.milesDriven;
			in1.name = 'milesDriven';
			var in2 = document.createElement('input');
			in2.value = event.gallonsUsed;
			in2.name = 'gallonsUsed';
			var in3 = document.createElement('input');
			in3.value = event.gasStation;
			in3.name = 'gasStation';
			var in4 = document.createElement('input');
			in4.value = event.comment;
			in4.name = 'comment';
			var btn = document.createElement('button')
			var btn2 = document.createElement('button')
			btn.type = 'submit';
			btn.textContent = 'Edit';
			btn.thing = event;
			btn.id = 'editBtn';
			
			btn.addEventListener('click', function(e){
				e.preventDefault();
				editEvent(event);
				
			});
			
			btn2.type = 'submit';
			btn2.textContent = 'Delete'
			btn2.value = 'Delete';
			btn2.id = 'deleteButton';
			btn2.addEventListener('click', function(e){
				e.preventDefault();
				deleteEvent(event);
				
			});
			
			myForm.appendChild(in1);
			myForm.appendChild(in2);
			myForm.appendChild(in3);
			myForm.appendChild(in4);
			myForm.appendChild(btn);
			myForm.appendChild(btn2);
			editDiv.appendChild(myForm);
			document.body.appendChild(editDiv);
			
	
			
			
			
		});
			for(var property in event){
				var td = document.createElement('td');
				td.textContent = `${property}` + ": " + `${event[property]}`
				tr.appendChild(td);
			}
			table.appendChild(tr);
	});
	
			eventDiv.appendChild(table);
		
	}

function postEvent() {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/mileages', true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
	  if (xhr.readyState === 4 ) {
	    if ( xhr.status < 400 ) { // Ok or Created
	      var data = JSON.parse(xhr.responseText);
	      console.log(data);
			displayAllEvents();

	    }
	    else {
	      console.log("POST request failed.");
	      console.error(xhr.status + ': ' + xhr.responseText);
	    }
	  }
	};
	var nff = document.getElementById('form');
	var event = {
	        milesDriven: nff.milesDriven.value, 
	        gallonsUsed: nff.gallonsUsed.value, 
	        gasStation: nff.gasStation.value, 
	        comment: nff.comments.value 
	        
	  };
	console.log(event);

	var eventObjectJson = JSON.stringify(event); // Convert JS object to JSON string

	xhr.send(eventObjectJson);
	
	}

function editEvent(event) {
	
	console.log('here');
	var xhr = new XMLHttpRequest();
	xhr.open('PATCH', `api/mileages/${event.id}`, true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
	  if (xhr.readyState === 4 ) {
	    if ( xhr.status == 200 || xhr.status == 201 ) { // Ok or Created
	      var data = JSON.parse(xhr.responseText);
	      console.log(data);
	  	displayAllEvents();

	    }
	    else {
	      console.log("PATCH request failed.");
	      console.error(xhr.status + ': ' + xhr.responseText);
	    }
	  }
	};
	var nff = document.getElementById('edit');
	var event = {
	        milesDriven: nff.milesDriven.value, 
	        gallonsUsed: nff.gallonsUsed.value, 
	        gasStation: nff.gasStation.value, 
	        comment: nff.comment.value 
	        
	  };
	console.log(event);

	var eventObjectJson = JSON.stringify(event); // Convert JS object to JSON string

	xhr.send(eventObjectJson);
	
	}
function deleteEvent(event) {
	
	console.log('deleting');
	console.log(event.id)
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', `api/mileages/${event.id}`, true);


	xhr.onreadystatechange = function() {
		console.log(xhr.readyState)
	  if (xhr.readyState === 4 ) {
	    if ( xhr.status == 200 || xhr.status == 204 || xhr.status == 201 ) { // Ok or Created
	      var data = JSON.parse(xhr.responseText);
	      console.log(data);
	      console.log('response - deleted')
	      displayAllEvents();
	      
	    }
	    else {
	      console.log("DELETE request failed.");
	      console.error(xhr.status + ': ' + xhr.responseText);
	    }
	  }
	};
	xhr.send(null);

	console.log(event);
        
	  };

	
	  function displayMpg(){
			 var xhr = new XMLHttpRequest();
			    xhr.open('GET', 'api/mileages/mpg', true);
			    	
			    xhr.onreadystatechange = function() {
			        if (xhr.readyState === 4 && xhr.status < 400) {
			            var data = JSON.parse(xhr.responseText);
			            console.log(data);
			            var mpgDiv = document.getElementById('mpgDiv');
			            mpgDiv.textContent = '';
			            var h1 = document.createElement('h1');
			            h1.textContent = 'Average MPG: ' + data.toFixed(2);
			            mpgDiv.appendChild(h1);
			            
			        }

			        if (xhr.readyState === 4 && xhr.status >= 400) {
			            console.error(xhr.status + ': ' + xhr.responseText);
			            var dataDiv = document.getElementById('eventDiv');
			            dataDiv.textContent = 'Event not found';

			        }
			    };

			    xhr.send(null);

			}
	
	


