import React from 'react';

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
                {/* change is returned here*/}
                <h4 className="text-center">Change</h4>
                <div className="text-center square border border-secondary" style={{height: "40px"}}>{changeStatement}</div>
                <div className="text-center">
                    {/* button for getting the change */}
                    <Button onClick={returnChange} variant="outline-secondary">
                        Change Return
                    </Button>
                </div>
            </Form>
        )
    }
}

export default PayBackForm