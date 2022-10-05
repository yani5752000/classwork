import React, { Component } from "react"
import { Routes, Route } from "react-router-dom"
import './App.css'
import NavBar from "./components/nav_bar"
import HomePage from './pages/home_page'
import AboutPage from './pages/about_page'

class App extends Component {
    render() {
        return (
            <div className="App">
                <NavBar />
                <main>
                    <Routes>
                        <Route exact path='/' component={HomePage} />
                        <Route path='/home' component={HomePage} />
                        <Route path='/about' component={AboutPage} />
                    </Routes>
                </main>
            </div>
        )
    }
}
 
export default App