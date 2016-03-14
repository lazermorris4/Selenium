<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UI Automation</title>
<style>

body {
background-color:"#4D6871";
background-image: url("http://cdn.wegotthiscovered.com/wp-content/uploads/avengers-2-age-of-ultron-it-s-going-to-be-bigger-better-and-with-a-lot-more-hawkeye-27a0fae2-4330-484c-9560-6fdb3afc2408.png");
}
h1{
background-color: #D1E0E0;
border:1px solid red;
padding:20px;
text-align: center;
color: #2E3D4C;

}
a:LINK {
    color:#00000;
    background-color:transparent;
    text-decoration:underline;
}
a:HOVER {
    color:red;
    color:#ff0000;
    text-decoration:underline;
}
a:VISITED {
    color:#000000;
    background-color:transparent;
    text-decoration:none;
}
table,th,td{
	border:1px solid black;
	border-collapse: collapse;
	}
	th{
	padding: 30px;text-align: center;
	}
    td{
	padding: 4px;text-align: center;
	}
	td, th{
	width: 500;
	/*background-color: #80AEBC;*/
	background-color: #D1E0E0;
    border:1px solid black;
    color: #2E3D4C;
	}
table,td,th{
	height: 10px;
	}
</style>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 <script type="text/javascript">
 function runCase(){
   
   var numberOfChBox = $('.publish').length;
   var checkArray = new Array();
   var nameArray = new Array();
   var browserArray = new Array();
   var urlName = $("#urldropdown0").val();
   console.log("URL Selected is"+urlName);
   var a;
   var b;
   var i;
   var j=0;
   var k;
   var status;
  
   for(i = 1; i <= numberOfChBox; i++) {
       nameArray[i-1]=$("#testcasename"+i).text();
       browserArray[i-1]=$("#dropdown"+ i).val();
       
       if($('#checkbox' + i).is(':checked')) {
           
           console.log("Checkbox"+i+"is checked");
           $.ajax({
               dataType : "text",
               url : "http://localhost:8080/TravelHome/test/"+i+"?testCase="+nameArray[i-1]+"&browser="+ browserArray[i-1]+"&url="+ urlName,
               async:false,
           }).done(function(response){
               status=response;
               console.log("Status is "+status);
               $("#Status"+(i)).html(response);
               if(status=='Passed'){
                   $("#Status"+(i)).css("color", "green");                   
               }
               else{
                   console.log("inside else");
                   $("#Status"+(i)).css("color", "red");
                   
               }
               console.log("response is "+response);
                 });          
     	}
       
       }

   }
 </script>
</head>

<body>
<h1>UI automation</h1>
<p><select name="urldropdown" id="urldropdown0"><option value="https://www.bankofamerica.com/sitemap/state-select.go">Bank of America login</option><option value="">American Airlines cargo</option><option value="https://www.yahoo.com">https://www.yahoo.com</option></select></p>
<FORM name="myform" method="get">
<table class="testcases">
<tr>
<th>Test Case ID</th><th>Test Case Name</th><th>Execute if checked</th><th>Browser Selection</th><th>Execution Status</th><th>Link to Screenshot</th>
</tr>
<tr>
<td>TC01</td><td><p class ="testcase" id="testcasename1" value="Planning new profile creation" align ="left">Validate that the newly created profile for planning is reflected in the drop down</p></td>
<td><input class="publish" type="checkbox" name="run1" value="run" id ="checkbox1"></td>
<td><select name="" id="dropdown1"><option value="Google Chrome">Google Chrome</option><option value="Mozilla Firefox">Mozilla Firefox</option><option value="Internet Explorer">Internet Explorer</option></select></td>
<td><p id ="Status1" value="S1">No Run</p></td>
<td><p id ="Screenshot1" value="SC1"><a href="1.png">Screenshot</a></p></td>
</tr>
<tr>
<td>TC02</td><td><p class ="testcase" id="testcasename2" value ="Bank of america checking account valdiation" align ="left">Validate the entries in the checking account for past 30 days</p></td>
<td><input class="publish" type="checkbox" name="run2" value="run" id ="checkbox2"></td>
<td><select name="" id="dropdown2"><option value="Google Chrome">Google Chrome</option><option value="Mozilla Firefox">Mozilla Firefox</option><option value="Internet Explorer">Internet Explorer</option></select></td>
<td><p id ="Status2" value="S2">No Run</p></td>
<td><p id ="Screenshot2" value="SC2"><a href="C:\Users\lmorr4\UIAutomation">Screenshot</a></p></td>
</tr>
<tr>
<td>TC03</td><td><p class ="testcase" id="testcasename3" value ="Third Validation" align ="left">Validate the presence of Feeling lucky button home page</p></td>
<td><input class="publish" type="checkbox" name="run3" value="run" id ="checkbox3"></td>
<td><select name="" id="dropdown3"><option value="Google Chrome">Google Chrome</option><option value="Mozilla Firefox">Mozilla Firefox</option><option value="Internet Explorer">Internet Explorer</option></select></td>
<td><p id ="Status3" value="S3">No Run</p></td>
<td><p id ="Screenshot3" value="SC3"><a href="C:\Users\lmorr4\UIAutomation">Screenshot</a></p></td>
</tr>
</table>
<br>
<br>
   <input name="submitButton"  type="button" align ="right" value="Submit" onclick="javascript:runCase()"/>

    </FORM>

</body>
</html>
