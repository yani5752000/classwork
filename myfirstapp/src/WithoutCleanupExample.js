import React, { useEffect, useState } from 'react';
import {Container, Row, Col } from 'react-bootstrap'
import Button from 'react-bootstrap/Button'
import 'bootstrap/dist/css/bootstrap.min.css';

function WithoutCleanupExample() {
    const [color, setColor] = useState("white");

    useEffect(() => {
        document.body.style = `background-color: ${color};`
    },[color])

    return(
        <div>
            <h3 className="text-center m-4">Select a Background Color:</h3>
            <Container >
                <Row className="justify-content-md-center " xl={4} >
                    <Col>
                        <Button variant="primary" onClick={() => {setColor("lightgreen")}}>Light Green</Button>
                    </Col>
                    <Col>
                        <Button variant="primary" onClick={() => {setColor("lightcoral")}}>Light Coral</Button>
                    </Col>
                    <Col>
                        <Button variant="primary" onClick={() => {setColor("lightcyan")}}>Light Cyan</Button>
                    </Col>
                    <Col>
                        <Button variant="primary" onClick={() => {setColor("white")}}>White</Button>
                    </Col>
                </Row>
            </Container>
        </div>
    )
}
export default WithoutCleanupExample;