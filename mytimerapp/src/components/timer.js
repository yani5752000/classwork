import React, { useEffect, useState } from "react";
import Alert from "react-bootstrap/Alert";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import "bootstrap/dist/css/bootstrap.min.css";

function Timer() {
    const [chrono, setChrono] = useState(25);
    
    useEffect(function () {
        runTimer();
    }, []);

    // Callback functions
    function runTimer() {
       setInterval(() => {
        setChrono(chrono - 1)
       }, 1000);
    }
    
    function filterSearchData(searchTerm) {
        
    }

    return (
        <div></div>
    );
}

export default Timer;