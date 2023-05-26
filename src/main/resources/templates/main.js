

//execute script after page load
window.onload = function digital_fn(){
    //toggle button
    let toggle = document.querySelector("toggle-btn");
    let collapse =document.getElementById("nav_collapse");
    let toggle2 = document.getElementById("toggle-btn");
    // to powoduje że pojawia sie element collapse po kliknieciu

   toggle2.addEventListener('click',function(event){
       collapse.classList.toggle('active')});
       
  //      console.log(toggle)
  //  const btn = document.getElementById('#nav.collapse');
  //  console.log(btn); // null
    
    // cannot read properties of null (reading 'addEventListener')
  // toggle2.addEventListener("click", () => {
  //   console.log('btn clicked')});
     
  


  //  });
}