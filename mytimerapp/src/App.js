// import logo from './logo.svg';
// import './App.css';
import { render } from "react-dom";
import Timer from './components/Timer';

function App() {
  return (
    <div className="flex flex-col justify-center">
      <header className="flex  justify-center p-4 bg-blue-100 border-b-2 border-blue-200 shadow-md">
        <h1 className="text-4xl ">The Timer</h1>
      </header>
      <Timer></Timer>
    </div>
  );
}

export default App;
