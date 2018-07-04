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
	
function fetchOldRecord(that){		
	   $("#uname").val($(that).parent().prev().text());
	   $("#uemail").val($(that).parent().prev().prev().prev().text());
	   $("#upass").val($(that).parent().prev().text());
	   $("#dt").val($(that).parent().prev().prev().prev().prev().text());
	   $("#hiddenuemail").val($(that).parent().prev().prev().prev().text());
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
					<th>Action</th>
				</tr>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
	</div>
      
     
     <div class="container" id="updateBlock">
		<div class="modal fade" id="updateModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Update New Information</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="uname" id="uname" class="form-control input-sm" placeholder="Full Name">
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="udeg" id="dt" class="form-control input-sm" placeholder="date" >
								</div>
							</div>
						</div>
						<div class="form-group">
							<input type="text" name="uemail" id="uemail" class="form-control input-sm" placeholder="Email">
							<input type="hidden" name="hiddenuemail" id="hiddenuemail">
						</div>
						<div class="form-group">
							<input type="" name="upass" id="upass" class="form-control input-sm" placeholder="Password">
						</div>
						<button onclick="updateNewRecord();" class="btn btn-info btn-block">Update</button>
						<div id="resp" class="text-center" style="margin-top: 13px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
      
     
    </div>
  </div>
</div>

