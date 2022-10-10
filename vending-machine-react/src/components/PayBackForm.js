import React from 'react';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form, Button } from 'react-bootstrap'

class PayBackForm extends React.Component {
    static defaultProps = {
        totalIn: 0
    }

    render() {
        return (
            <Form>
                <div>Total $ In</div>
                <div>{this.props.totalIn}</div>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
                
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        )
    }
}

export default PayBackForm