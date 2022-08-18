import React, { useEffect, useState } from "react";
import Alert from "react-bootstrap/Alert";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import {Container, Row, Col } from 'react-bootstrap'
import "bootstrap/dist/css/bootstrap.min.css";

let count = 25;
function Timer() {
    const [countingOn, setCountingOn] = useState(false);
    const [chrono, setChrono] = useState(25);
    const [countDowns, setCountDowns] = useState(0);
    const [pauses, setPauses] = useState(0);
    //let keepGoing = false;
    useEffect(
        () => {
                // if(counting) {
                //     count = chrono;
                //     runTimer();
                // }
                //count = chrono;
                if(countingOn){
                    runTimer();
                }
                    
            }
    )

    function decrease() {
        
        if(chrono > -5) {
            setChrono(chrono - 1);
            console.log("hi " + chrono);
            if(chrono === 1) {
                setCountDowns(countDowns + 1);
            }
        } else {
            setPauses(pauses + 1);
            setChrono(25);
        }
        
    }
    

    // Callback functions
    function runTimer() {
        setTimeout(() => {
            decrease();
            //setCounting(!counting);
        }, 1000)
        }
        
       

    return (
        <div>
            {chrono >= 0 && <p>{chrono}</p>}
            {chrono < 0 && <p>0</p>}
            <p>Countdowns: {countDowns}</p>
            <p>Pauses: {pauses}</p>
            <Row className="justify-content-md-center " xl={4} >
                    <Col>
                        <Button variant="primary" onClick={() => {setCountingOn(true)}}>Start</Button>
                    </Col>
                    <Col>
                        <Button variant="primary" onClick={() => {setCountingOn(false)}}>Stop</Button>
                    </Col>
            </Row>
            
        </div>
        
    );
}

export default Timer;