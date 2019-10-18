var name=0;
var email=0;
var gender=0;
var password=0;
var cpassword=0;
var phone = 0;




function a(){
  

  if (document.getElementById('option1').checked) {
      gender = document.getElementById('option1').value;
    }
    else{
     gender = document.getElementById('option2').value;
    }
 
    name = document.getElementById('name').value;
    email = document.getElementById('email').value;
   
    phone=document.getElementById('phone').value;
     password = document.getElementById('password').value;
     cpassword = document.getElementById('cpassword').value;
    

 
 
    
  if(password==cpassword && email!=0 && name!=0 && password!=0 && cpassword!=0 && gender!=0 && phone!=0){
      axios.post('',{
      name:name,
      email: email,
      password: password,
      cpassword: cpassword,
      gender:gender,
      phone:phone,
     
      
      
  })
  .then((response)=>{
  
      console.log("yesssss");
      alert('You have been registered successfully');
  })
  .catch((error)=>{
  
      console.log(error);
  })
     }
     else if(password!=cpassword){
       alert('Password not match');
     }
     else if(password ==0 || cpassword ==0 || name ==0 || gender==0 || phone==0 || email==0){
       alert('All fields are required');
     }

}





  
