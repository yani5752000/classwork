import React, { Component } from "react"
import { Routes, Route } from "react-router-dom"
import './App.css'
import NavBar from "./components/nav_bar"
import HomePage from './pages/home_page'
import AboutPage from './pages/about_page'
import DashboardPage from "./pages/dashboard_page"

class App extends Component {
    render() {
        return (
            <div className="App">
                <NavBar />
                <Routes>
                    <Route exact path='/' element={<HomePage />} />
                    <Route path='/home' element={<HomePage />} />
                    <Route path='/dashboard' element={<DashboardPage />} />
                    <Route path='/about' element={<AboutPage />} />
                </Routes>
            </div>
        )
    }
}
 
export default App