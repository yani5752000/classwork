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
        setChrono(chrono - 1);
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
            <p>{chrono}</p>
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