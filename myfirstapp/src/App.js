import React from 'react';
import logo from './logo.svg';
import './App.css';
import Person from './Person';
import Car from './Car';
import AuthorInfo from './AuthorInfo';
import LlamaHerd from './LlamaHerd';
import ExampleComponent from './ExampleComponent';
import WithoutCleanupExample from './WithoutCleanupExample';
import {Button, Badge} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import WithCleanupExample from './WithCleanupExample';




function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Person name='David'></Person>
        <AuthorInfo author='Ada Lovelace' email='ada@lovelace.com'></AuthorInfo>
        <Car></Car>
        <LlamaHerd></LlamaHerd>
        <ExampleComponent></ExampleComponent>
        <WithoutCleanupExample></WithoutCleanupExample>
        <WithCleanupExample></WithCleanupExample>
      </header>
    </div>
  );
}
export default App;