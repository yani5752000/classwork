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
        //now first we get the props coming from App.js
        let {deposit, addToDeposit} = this.props;
        return (
            //here is the form for paying in
            <Form>
                {/* displaying the total amount deposited */}
                <h4 className="text-center">Total $ In</h4>
                
                <div className="text-center square border border-secondary">{deposit}</div>
                <div className="text-center">
                    {/* the button for depositing one dollar */}
                  <Button variant="outline-secondary" name="dollar" onClick={addToDeposit}>
                      Add Dollar
                  </Button>
                  {/* the button for depositing one quarter */}
                  <Button variant="outline-secondary" name="quarter" onClick={addToDeposit}>
                      Add Quarter
                  </Button>
                </div>
                {/* <br /> */}
                <div className="text-center">
                    {/* and the button for depositing one dime */}
                  <Button variant="outline-secondary" name="dime" onClick={addToDeposit}>
                      Add Dime
                  </Button>
                  {/* here we have the button for depositing one nickel */}
                  <Button variant="outline-secondary" name="nickle" onClick={addToDeposit}>
                      Add Nickel
                  </Button>    
                </div>
                
            </Form>
        )
    }
}

export default PayInForm