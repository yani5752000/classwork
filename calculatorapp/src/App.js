// import logo from './logo.svg';
// import './App.css';
import Parent from "./components/Parent";

function App() {
  return (
    <div className="flex flex-col justify-center">
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a> */}
      </header>
      <Parent></Parent>
    </div>
  );
}

export default App;
