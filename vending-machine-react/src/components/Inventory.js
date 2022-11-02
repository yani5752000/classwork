import React from 'react';
import Card from 'react-bootstrap/Card'
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import "bootstrap/dist/css/bootstrap.min.css";


class Inventory extends React.Component {

    // this static property will initialize a prop with data
    // if it hasn't been provided by the parent component
    static defaultProps = {
        items: [ 
            { 
              "id": 1, 
              "name": "Snickers", 
              "price": 1.5, 
              "quantity": 10 
            }, 
            { 
              "id": 42, 
              "name": "M&M's", 
              "price": 1.25, 
              "quantity": 8 
            }, 
            { 
              "id": 33, 
              "name": "Almond Joy", 
              "price": 1.25, 
              "quantity": 11 
            }, 
            { 
              "id": 74, 
              "name": "Milky Way", 
              "price": 1.65, 
              "quantity": 3 
            }, 
            { 
              "id": 5, 
              "name": "Payday", 
              "price": 1.75, 
              "quantity": 2 
            }, 
            { 
              "id": 16, 
              "name": "Reese's", 
              "price": 1.5, 
              "quantity": 5 
            }, 
            { 
              "id": 87, 
              "name": "Pringles", 
              "price": 2.35, 
              "quantity": 4 
            }, 
            { 
              "id": 82, 
              "name": "Cheez-Its", 
              "price": 2, 
              "quantity": 6 
            }, 
            { 
              "id": 9, 
              "name": "Doritos", 
              "price": 1.95, 
              "quantity": 7 
            } 
          ] 
    }

    render() {
        let {getItemNumber} = this.props;
        // Here is a debug method to monitor incoming item's data
        console.log("Rendering Items' Cards:")
        console.log(this.props.items)
        return (
          //display the items in rows of three each
            <Row xs={1} md={3} className="g-4">
      {this.props.items.map((item, index) => (
        <Col>
          <Card key={index} id={index + 1} onClick={getItemNumber}>
            <Card.Header id={index + 1}>{index + 1}</Card.Header>
            <Card.Body id={index + 1}>
              <Card.Title id={index + 1} className="text-center">{item.name}</Card.Title>
              <Card.Text id={index + 1} className="text-center">${item.price}</Card.Text>
              <Card.Text id={index + 1} className="text-center">Quantity Left: {item.quantity}</Card.Text>
            </Card.Body>
          </Card>
        </Col>
      ))}
    </Row>
            )
    }
}


export default Inventory