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
            //and here is the form for paying in
            <Form>
                {/* first displaying the total amount deposited */}
                <h4 className="text-center">Total $ In</h4>
                
                <div className="text-center square border border-secondary">{deposit}</div>
                <div className="text-center">
                    {/* and here we have the button for depositing one dollar coin */}
                  <Button variant="outline-secondary" name="dollar" onClick={addToDeposit}>
                      Add Dollar
                  </Button>
                  {/* and here the button for depositing one quarter coin*/}
                  <Button variant="outline-secondary" name="quarter" onClick={addToDeposit}>
                      Add Quarter
                  </Button>
                </div>
                {/* <br /> */}
                <div className="text-center">
                    {/* and here the button for depositing one dime coin */}
                  <Button variant="outline-secondary" name="dime" onClick={addToDeposit}>
                      Add Dime
                  </Button>
                  {/* and here we have the button for depositing one nickel coin */}
                  <Button variant="outline-secondary" name="nickle" onClick={addToDeposit}>
                      Add Nickel
                  </Button>    
                </div>
                
            </Form>
        )
    }
}

export default PayInForm