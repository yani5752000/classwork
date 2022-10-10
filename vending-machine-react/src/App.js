import React from 'react';
import './App.css';
import Inventory from './components/Inventory';
import PayInForm from './components/PayInForm';
import MessageForm from './components/MessageForm';
import PayBackForm from './components/PayBackForm';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';

const SERVICE_URL = "http://vending.us-east-1.elasticbeanstalk.com/"

class App extends React.Component {

  state = {
    loading: false,
    itemsData: [
      { 
        "id": 1, 
        "name": "Snickers", 
        "price": 1.5, 
        "quantity": 10 
      }]
  }

  componentDidMount() {
    console.log("App is now mounted.")
    this.setState({ loading: true })
    console.log("Loading items' data")
    fetch(SERVICE_URL + "/items")
      .then(data => data.json())
      .then(data => this.setState(
        { itemsData: data, loading: false }
      ))
  }

  render() {
    return (
      <Container fluid>
        <Row>
          <Col>
            <h1 className="text-center">Vending Machine</h1>
          </Col>
        </Row>
        <hr />
        <Row>
          <Col sm={8}>
            <Inventory items={this.state.itemsData} />
          </Col>
          <Col sm={4}>
            <Row>
              <Col>
                <PayInForm />
              </Col>
            </Row>
            <hr />
            <Row>
              <Col>
                <h2>Messages</h2>
                <MessageForm />
              </Col>
            </Row>
            <hr />
            <Row>
              <Col>
                <h2>Change</h2>
                <PayBackForm />
              </Col>
            </Row>
          </Col>
        </Row>
        {/* <ContactModal /> */}
      </Container>
    );
  }
}

export default App;
