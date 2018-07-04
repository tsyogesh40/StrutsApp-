
<script type="text/javascript">
             function adduser() {
                // get the form values
              
                var email = $('#email').val();
                var name= $('#name').val();
                var pwd=$('#pswd').val();
                $.ajax({
                    type: "POST",
                    url: "./signup.action",
                    data: "email="+email+"&name="+name+"&password="+pwd,
                    success: function(data){
                        // we have the response
                       
                        //alert(response);
                
                        //$('#info').html(response);
                      //  $('#msg').html().show();
                       
                    },
                    error: function(e){
                        alert('Error: ' + e);
                    }
                });
            }
        </script>
        
<div class="col-sm-9">
	<div id="info"></div>
	  <div id="signupbox"  class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Add Users</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" method="post">
                               
                                <div class="alert alert-success" id="msg" style="display:none; margin-top:50px">
  							<strong>Success!</strong> User Added.
								</div>
                               
                                    
                                                    
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="email" placeholder="Email Address" id="email">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="firstname" class="col-md-3 control-label">First Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="name" placeholder="First Name" id="name")>
                                    </div>
                                </div>
                              
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="password" placeholder="Password" id="pswd">
                                    </div>
                                </div>
                                    
                               

                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" onclick="adduser()" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Add</button>
                                    </div>
                                </div>
                                
                                
                                
                                
                                
                            </form>
                         </div>
                    </div>

               
               
                
         </div> 
    </div>
    
	
</div>