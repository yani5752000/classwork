import React, {useState} from 'react';
  
  function ExampleComponent(){
  
      const [age,setAge] = useState(0);
  
      return(
          <div>
              <p>Your current age is {age}</p>
              <form>
                  <input type="number" name="age" id="age" onChange={(e)=> setAge(e.target.value)} />
              </form>
          </div>
      )
}

export default ExampleComponent