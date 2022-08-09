import React from 'react';
import logo from './logo.svg';
import './App.css';
import Person from './Person';
import Car from './Car';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Person name='David'></Person>
        <Car></Car>
      </header>
    </div>
  );
}
export default App;