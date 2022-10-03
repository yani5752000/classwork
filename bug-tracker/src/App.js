import React, { Component } from "react";
import SubmitFormHtml from "./components/SubmitFormHtml";
import SetStateExample from "./components/SetStateExample";
 
class App extends Component {
  render() {
    return (
      <div className="container">
        <h3>React Form - HTML</h3>
        <SetStateExample></SetStateExample>
        <SubmitFormHtml />
        <br />
      </div>
    );
  }
}
 
export default App;