import React from 'react';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form, Button } from 'react-bootstrap'

class PayInForm extends React.Component {
    static defaultProps = {
        totalIn: 0
    }

    render() {
        return (
            <Form>
                <h4 className="text-center">Total $ In</h4>
                <div className="text-center">{this.props.totalIn}</div>
                <div className="text-center">
                  <Button variant="primary" >
                      Add Dollar
                  </Button>
                  <Button variant="primary" >
                      Add Quarter
                  </Button>
                </div>
                <br />
                <div className="text-center">
                  <Button variant="primary" >
                      Add Dime
                  </Button>
                  <Button variant="primary" >
                      Add Nickle
                  </Button>    
                </div>
                
            </Form>
        )
    }
}

export default PayInForm