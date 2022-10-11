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
        return (
            <Form>
                <h4 className="text-center">Messages</h4>
                <div className="text-center">{this.props.message}</div>
                <h4 className="text-center">Item: {this.props.item}</h4>
                <div className="text-center">
                    <Button variant="primary">
                        Make Purchase
                    </Button>
                </div>
            </Form>
        )
    }
}

export default MessageForm