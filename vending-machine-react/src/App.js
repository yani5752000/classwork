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
      deposit: 0,
      hi: "hiiii",
      itemsData1: [
        { 
          "id": 1, 
          "name": "Snickers", 
          "price": 1.5, 
          "quantity": 10 
        }]
  }
  
  addToDeposit(event) {
    let inputValue = event.target.value;
    // let x = this.state.deposit;
    // let v = 200;
    // console.log("here we are: ", this.state.hi);
    this.setState(prevState => ({
      deposit: prevState.deposit + 100
    }), () => console.log(this.state));
  
    // this.setState({deposit: this.state.deposit + 1});
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
            <h4>{this.state.hi}</h4>
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
                <PayInForm deposit={this.state.deposit} addToDeposit={this.addToDeposit} />
              </Col>
            </Row>
            <hr />
            <Row>
              <Col>
                <MessageForm />
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
