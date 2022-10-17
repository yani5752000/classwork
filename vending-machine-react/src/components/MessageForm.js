import React from 'react';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form, Button } from 'react-bootstrap'

class MessageForm extends React.Component {
    static defaultProps = {
        message: "thank you",
        item: 1
    }

    render() {
        let { itemNumber, makePurchase, message } = this.props;
        return (
            <Form>
                <h4 className="text-center">Messages</h4>
                <div className="text-center square border border-secondary" style={{height: "40px"}}>{message}</div>
                {/* <h4 className="text-center">Item: {itemNumber}</h4> */}
                <Row>
                    <Col sm={4}  className="text-right">Item: </Col>
                    <Col sm={8} className='row'>
                        <div className="text-center square border border-secondary" style={{height: "40px"}}>
                            {itemNumber}
                        </div>
                    </Col>
                </Row>
                
                <div className="text-center">
                    <Button variant="outline-secondary" onClick={makePurchase} >
                        Make Purchase
                    </Button>
                </div>
            </Form>
        )
    }
}

export default MessageForm