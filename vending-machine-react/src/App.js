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
    itemNumber: null,
    message: "",
    responseChange: {
      quarters: 0,
      dimes: 0,
      nickels: 0,
      pennies: 0
    },
    changeStatement: ""
  }

  returnChange = (event) => {
    this.setState({
      deposit: (0).toFixed(2),
      changeStatement: ""
    });
  }

  accordChange = () => {
    console.log("Hi1 ", this.state.responseChange);
    let statement = "";
    if (this.state.responseChange.quarters == 1) {
      statement += "1 Quarter";
    }
    if (this.state.responseChange.quarters > 1) {
      statement += this.state.responseChange.quarters + " Quarters";
    }
    if (this.state.responseChange.dimes == 1) {
      statement += " 1 Dime";
    }
    if (this.state.responseChange.dimes > 1) {
      statement += " " + this.state.responseChange.dimes + " Dimes";
    }
    if (this.state.responseChange.nickels == 1) {
      statement += " 1 Nickel";
    }
    if (this.state.responseChange.nickels > 1) {
      statement += " " + this.state.responseChange.nickels + " Nickels";
    }
    if (this.state.responseChange.pennies == 1) {
      statement += " 1 Pence";
    }
    if (this.state.responseChange.dimes > 1) {
      statement += " " + this.state.responseChange.pennies + " Pennies";
    }

    console.log("statement ", statement);

    // return statement;

    this.setState({
      changeStatement: statement
    });
    
  }

  makePurchase = (event) => {
    if (!this.state.itemNumber) {
      this.setState({message: "Please make a selection"});
      this.loadItemsData();
      return;
    }
    let id = this.state.itemsData[this.state.itemNumber - 1].id;
    let price = this.state.itemsData[this.state.itemNumber - 1].price;
    console.log("id: ", id)

    fetch(SERVICE_URL+'/money/'+this.state.deposit+'/item/'+id, {
        method: 'POST'
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        if (data.message) {
          this.setState({message: data.message});
          return;
        }
        console.log("res ch1:", this.state.responseChange);
        console.log("data1: ", data);
        // this.setState({
        //   deposit:( this.state.deposit - price ).toFixed(2),
        //   message:  'Thank You!!!',
        //   responseChange: data
        // })

        
        this.setState(prevState => ({
          deposit: ( prevState.deposit - price ).toFixed(2),
          message:  'Thank You!!!',
          responseChange: data
        }), () => {
          console.log("res ch is: ", this.state.responseChange);
          this.accordChange();
        });

        console.log("data2: ", data);

        console.log("res ch2:", this.state.responseChange);

        // this.accordChange();

        this.loadItemsData();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
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

  loadItemsData() {
    this.setState({ loading: true })
    console.log("Loading items' data")
    fetch(SERVICE_URL + "/items")
      .then(data => data.json())
      .then(data => this.setState(
        { itemsData: data, loading: false }
      ))
  }

  componentDidMount() {
    console.log("App is now mounted.")
    console.log("Loading items' data")
    this.loadItemsData();
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
                <MessageForm 
                itemNumber={this.state.itemNumber} 
                makePurchase={this.makePurchase}
                message={this.state.message} />
              </Col>
            </Row>
            <hr />
            <Row>
              <Col>
                <PayBackForm
                // accordChange={this.accordChange}
                changeStatement={this.state.changeStatement}
                returnChange={this.returnChange} />
              </Col>
            </Row>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default App;
