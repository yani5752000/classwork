import React, { Component } from "react"
import { Routes, Route } from "react-router-dom"
import './App.css'
import NavBar from "./components/nav_bar"
import HomePage from './pages/home_page'
import AboutPage from './pages/about_page'
import DashboardPage from "./pages/dashboard_page"
import ReviewsTable from "./components/reviews_table"

class App extends Component {
    render() {
        return (
            <div className="App">
                <NavBar />
                <main>
                    <Routes>
                        <Route path='/' element={<HomePage />} />
                        <Route path='/home' element={<HomePage />} />
                        <Route path='/dashboard' element={<DashboardPage />} />
                        <Route path='/about' element={<AboutPage />} />
                        <Route path='/dashboard/reviews_table' element={<ReviewsTable />} />
                    </Routes>
                </main>
                {/* <Routes>
                    <Route path='/' element={<HomePage />} />
                    <Route path='/home' element={<HomePage />} />
                    <Route path='/dashboard' element={<DashboardPage />} />
                    <Route path='/about' element={<AboutPage />} />
                    <Route path='/dashboard/reviews_table' element={<ReviewsTable />} />
                </Routes> */}
            </div>
        )
    }
}
 
export default App