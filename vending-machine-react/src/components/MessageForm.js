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
                <div className="text-center">{message}</div>
                <h4 className="text-center">Item: {itemNumber}</h4>
                <div className="text-center">
                    <Button onClick={makePurchase} variant="primary">
                        Make Purchase
                    </Button>
                </div>
            </Form>
        )
    }
}

export default MessageForm