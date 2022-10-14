import React from 'react';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form, Button } from 'react-bootstrap'

class PayBackForm extends React.Component {
    static defaultProps = {
        change: 1.25
    }

    render() {
        let { changeStatement, returnChange } = this.props;
        return (
            <Form>
                <h4 className="text-center">Change</h4>
                <div className="text-center">{changeStatement}</div>
                <div className="text-center">
                    <Button onClick={returnChange} variant="primary">
                        Change Return
                    </Button>
                </div>
            </Form>
        )
    }
}

export default PayBackForm