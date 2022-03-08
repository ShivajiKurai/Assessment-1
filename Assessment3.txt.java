import $ from "jquery";
function toggle(button)

{
    
   switch(button.value)
    
{
       
    case "ON":
           
    button.value = "OFF";
          
    break;
        
    case "OFF":
            
    button.value = "ON";
           
    break;
    
}

}