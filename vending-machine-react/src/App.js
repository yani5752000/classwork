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
      }],
    deposit: (0).toFixed(2),
    itemNumber: 0
  }

  getItemNumber = (event) => {
    console.log("target: ", event.target);
    console.log("event target id: ", event.target.id);
    let itemNumber = event.target.id;
    console.log("item Number: ", itemNumber);
    this.setState({itemNumber: itemNumber});
  }
  
  addToDeposit = (event) => {
    let inputValue;
    switch ( event.target.name ) {
      case "dollar": inputValue = 100;
      break;
      case "quarter": inputValue = 25;
      break
      case "dime": inputValue = 10;
      break;
      case "nickle": inputValue = 5;
      break;
      default: break;
    }

    this.setState(prevState => ({
      deposit: (( prevState.deposit * 100 + inputValue ) / 100).toFixed(2)
    }), () => console.log(this.state));
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
            <Inventory 
            items={this.state.itemsData} 
            getItemNumber={this.getItemNumber} />
          </Col>
          <Col sm={4}>
            <Row>
              <Col>
                <PayInForm deposit={this.state.deposit} addToDeposit={this.addToDeposit} />
              </Col>
            </Row>
            <hr />
            <Row>
              <Col>
                <MessageForm itemNumber={this.state.itemNumber} />
              </Col>
            </Row>
            <hr />
            <Row>
              <Col>
                <PayBackForm />
              </Col>
            </Row>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default App;
