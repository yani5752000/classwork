import React, { Component } from 'react';

class LlamaHerd extends React.Component{
 state = {
  llamaHerd : ["Felicity", "Beebop", "Dixie", "Oreo", "Boo", "Angelina", "Floyd", "Cayenna"]
 }

 render(){
  let {llamaHerd} = this.state;
  return (<div><ol>
      {llamaHerd.map((llama,i) => <li key={i}>{llama}</li>)}
    </ol></div>)
  }
}

export default LlamaHerd;