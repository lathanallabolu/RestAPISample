<html>

<head>
<Script>

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
	   if (ajaxRequest.readyState == 4) {
	      if (ajaxRequest.status == 200) {
	    	  console.log("success");
	    	  alert(ajaxRequest.responseText);
	      }else{
	    	  console.log("failure in 200");
	      }
	   }else{
		   console.log("failure in ready state");
	   }
}   
	           
</Script>

</head>
<body>

    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/customer/1">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
    
    <form>
        
        <input type="text" value="">
        
        <button type="button" onclick="validateUserId()">Ajax Call</button>
    </form>
</body>
</html>
