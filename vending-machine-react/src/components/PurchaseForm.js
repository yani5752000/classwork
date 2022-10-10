import React from 'react';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form, Button } from 'react-bootstrap'

class PurchaseForm extends React.Component {

    render() {
        return (
            <Form>
                <div>Total $ In</div>
                <Form.Group controlId="contactFirstName">
                    <Form.Label>Total $ In</Form.Label>
                    <Form.Control type="text" placeholder="" name="cash"/>
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
                </Form.Group>
                <Form.Group controlId="contactLastName">
                    <Form.Label>Last Name:</Form.Label>
                    <Form.Control type="text" placeholder="Last Name" name="lastName"/>
                </Form.Group>
                <Form.Group controlId="contactCompany">
                    <Form.Label>Company:</Form.Label>
                    <Form.Control type="text" placeholder="Company" name="company"/>
                </Form.Group>
                <Form.Group controlId="contactPhone">
                    <Form.Label>Phone Number:</Form.Label>
                    <Form.Control type="phone" placeholder="Phone Number" name="phone" />
                </Form.Group>
                <Form.Group controlId="contactEmail">
                    <Form.Label>Email:</Form.Label>
                    <Form.Control type="email" placeholder="Email" name="email"/>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        )
    }
}

export default PurchaseForm