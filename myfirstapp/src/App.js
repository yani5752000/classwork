import React from 'react';
import logo from './logo.svg';
import './App.css';
import Person from './Person';
import Car from './Car';
import AuthorInfo from './AuthorInfo';
import LlamaHerd from './LlamaHerd';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Person name='David'></Person>
        <AuthorInfo author='Ada Lovelace' email='ada@lovelace.com'></AuthorInfo>
        <Car></Car>
        <LlamaHerd></LlamaHerd>
      </header>
    </div>
  );
}
export default App;