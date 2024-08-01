
//DOM's get ElementsById method returns a live HTMLCollection of elements with the specified Id.
let input = document.getElementById('inputBox');
//DOM's queryslectorall  method returns a static (not live) NodeList representing a list of elements within the document which match
//The value property represents the current value in an <input> element, and is used to
let buttons = document.querySelectorAll('button');

// Create an empty string
let string = "";
// Reserve all the buttons  in an array and add a click event listener to each button 
let arr = Array.from(buttons);

// Create all functionality under the ForEach loop
arr.forEach(button => {
    button.addEventListener('click', (e) =>{

        // for the equal key :-
        if(e.target.innerHTML == '='){
            string = eval(string);
            input.value = string;
        }
        // for the all clear(AC) :-
        else if(e.target.innerHTML == 'AC'){
            string = "";
            input.value = string;
        }
        // for the delete key :-
        else if(e.target.innerHTML == 'DEL'){
            string = string.substring(0, string.length-1);
            input.value = string;
        }
        // add other functionalities here...
        else{
            string += e.target.innerHTML;
            input.value = string;
        }
        
    });
});