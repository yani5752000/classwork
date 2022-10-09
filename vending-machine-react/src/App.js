import logo from './logo.svg';
import './App.css';
import Inventory from './components/Inventory';
import PayInForm from './components/PayInForm';
import MessageForm from './components/MessageForm';
import PayBackForm from './components/PayBackForm';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
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
          <Inventory />
        </Col>
        <Col sm={4}>
          <Row>
            <Col>
              <h2>Total $ In</h2>
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

export default App;
