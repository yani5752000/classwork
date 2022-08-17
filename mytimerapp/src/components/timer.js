import React, { useEffect, useState } from "react";
import Alert from "react-bootstrap/Alert";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import {Container, Row, Col } from 'react-bootstrap'
import "bootstrap/dist/css/bootstrap.min.css";

let count;
function Timer() {
    const [chrono, setChrono] = useState(25);
    useEffect(
        () => {
            // EFFECT LOGIC
            var timeout
        
            clearTimeout(timeout);
                timeout = setTimeout(() => {
                decrease();
                }, 1000);
        
            //EFFECT CLEAN UP
            return function cleanUp() {
                console.log("Cleaned up")
                clearTimeout(timeout);
                document.onmousemove = null;
            };
            }
    )

    function decrease() {
        setChrono(chrono - 1);
    }
    

    // Callback functions
    function runTimer() {
        setTimeout(() => decrease(), 1000)
        }
        
       

    return (
        <div>
            <p>{chrono}</p>
            <Row className="justify-content-md-center " xl={4} >
                    <Col>
                        <Button variant="primary" onClick={() => {runTimer()}}>Start</Button>
                    </Col>
                    {/* <Col>
                        <Button variant="primary" onClick={() => {setColor("lightcoral")}}>Light Coral</Button>
                    </Col> */}
            </Row>
            
        </div>
        
    );
}

export default Timer;