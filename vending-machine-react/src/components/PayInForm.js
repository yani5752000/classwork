import React from 'react';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form, Button } from 'react-bootstrap'

class PayInForm extends React.Component {
    static defaultProps = {
        totalIn: 0,
        dollar: 100,
        quarter: 25,
        dime: 10,
        nickle: 5
    }

    render() {
        let {deposit, addToDeposit} = this.props;
        return (
            <Form>
                <h4 className="text-center">Total $ In</h4>
                <div className="text-center">{deposit}</div>
                <div className="text-center">
                  <Button variant="primary" name="dollar" onClick={addToDeposit}>
                      Add Dollar
                  </Button>
                  <Button variant="primary" name="quarter" onClick={addToDeposit}>
                      Add Quarter
                  </Button>
                </div>
                <br />
                <div className="text-center">
                  <Button variant="primary" name="dime" onClick={addToDeposit}>
                      Add Dime
                  </Button>
                  <Button variant="primary" name="nickle" onClick={addToDeposit}>
                      Add Nickle
                  </Button>    
                </div>
                
            </Form>
        )
    }
}

export default PayInForm