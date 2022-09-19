import React, { Component } from "react";
import SubmitFormHtml from "./components/SubmitFormHtml";
 
class App extends Component {
  render() {
    return (
      <div className="container">
        <h3>React Form - HTML</h3>
        <SubmitFormHtml />
        <br />
      </div>
    );
  }
}
 
export default App;