<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="col-sm-9">
      <h4><small>Users List</small></h4>
      <hr>
      <button type="button" onclick="report()" class="btn btn-primary">View All</button>
      <script>
function report() {		
		$.ajax({			
			type:"GET",
			url:"./register.action",
			success: function(result){
				var tblData="";
				$.each(result.li, function() {					
					tblData += "<tr><td>" + this.date + "</td>" + 
					"<td>" + this.email + "</td>" + 
					"<td>" + this.name + "</td>" + 
					"<td>" + this.password + "</td>" +
					"<td>"+
					"<button onclick='fetchOldRecord(this);' class='btn btn-sm btn-info' data-toggle='modal' data-target='#updateModal'>Update</button>"+
					"<button onclick='deleteUser(this);' class='btn btn-sm btn-danger'>Delete</button>"+
					"</td></tr>" ;
				});
				$("#table").show();
				$("#tbody").html(tblData);
			},
			error: function(result){
				alert("Some error occured.");
			}
		});
	}
</script>
	<div class="container" style="display:none; margin-top:50px" id="table">
		<table class="table table-bordered">
			<thead>
				<tr class="bg-info">
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Created On</th>
				</tr>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
	</div>
      
     
      
     
    </div>
  </div>
</div>


</body>
</html>