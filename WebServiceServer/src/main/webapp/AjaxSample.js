/**
 * 
 */


var ajaxRequest;  // The variable that makes Ajax possible!
function ajaxFunction(){
   try{
      
      // Opera 8.0+, Firefox, Safari
      ajaxRequest = new XMLHttpRequest();
   }catch (e){
   
      // Internet Explorer Browsers
      try{
         ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
      }catch (e) {
      
         try{
            ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
         }catch (e){
      
            // Something went wrong
            alert("Your browser broke!");
            return false;
         }
      }
   }
}
function validateUserId() {
	
	console.log("inside validateuser");
	   ajaxFunction();
	   
	   // Here processRequest() is the callback function.
	   ajaxRequest.onreadystatechange = processRequest;
	   
	   console.log("after process request"); 
	   var url = "http://localhost:9999/WebServiceServer/webapi/customer/get/" + 1;
	   
	   ajaxRequest.open("GET", url, true);
	   ajaxRequest.send(null);
	}

function processRequest() {
	   if (req.readyState == 4) {
	      if (req.status == 200) {
	    	  cosole.log("success");
	    	  alert(ajaxRequest.responseText);
	      }else{
	    	  cosole.log("failure in 200");
	      }
	   }else{
		   cosole.log("failure in ready state");
	   }
}   
	           
	      
	   