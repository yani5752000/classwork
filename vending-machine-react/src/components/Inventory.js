import React from 'react';
import Card from 'react-bootstrap/Card'
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import "bootstrap/dist/css/bootstrap.min.css";


// function Inventory (){
//   return <h1>Inventory</h1>
// }

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
        // Here is a debug method to monitor incoming contact data
        console.log("Rendering Items' Cards:")
        console.log(this.props.items)
        return (
            <Row xs={1} md={3} className="g-4">
      {this.props.items.map((item, id) => (
        <Col>
          <Card>
            <Card.Header>{id + 1}</Card.Header>
            <Card.Body>
              <Card.Title className="text-center">{item.name}</Card.Title>
              <Card.Text className="text-center">${item.price}</Card.Text>
              <Card.Text className="text-center">Quantity Left: {item.quantity}</Card.Text>
            </Card.Body>
          </Card>
        </Col>
      ))}
    </Row>
            )
    }
}


export default Inventory