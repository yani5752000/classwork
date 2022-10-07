import React, { Component } from "react"
import { Routes, Route } from "react-router-dom"
import reviewStore from '../stores/review_store'
import DashboardMenu from "../components/dashboard_menu"
import ReviewsTable from "../components/reviews_table"
import HomePage from "./home_page"
import AboutPage from "./about_page"

class DashboardPage extends Component {
    componentDidMount() {
        let dataUrl = "http://localhost:3000/data/reviews_Musical_Instruments_5.json"
        reviewStore.loadData(dataUrl)
    }
 
    render() {
        return (
            <div id="dashboard_page" className="App-page">
                <DashboardMenu/>
                {/* <Routes>
                    <Route path='/dashboard' element={() => { this.render(<div>Dashboard Content</div>) }} />
                    <Route path='/dashboard/reviews_table' element={<ReviewsTable />} />
                </Routes> */}
            </div>
        )
    }
}
 
export default DashboardPage
 
