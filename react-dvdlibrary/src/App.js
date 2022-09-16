import React from 'react';

import DVDTable from './components/DVDTable';
import SerachForm from './components/SerachForm';
import CreateButton from './components/CreateButton';
import CreateModal from './components/CreateModal';
import DeleteModal from './components/DeleteModal';
import EditModal from './components/EditModal';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
  return (
    <Container fluid>
      <Row>
        <Col sm={4}>
          <CreateButton />
        </Col>
        <Col sm={8}>
          <SerachForm />
        </Col>
      </Row>
      <hr />
      <Row>
        <Col className="text-center">
          <DVDTable />
        </Col>
      </Row>
      <hr />
      {/* <CreateModal /> */}
      {/* <EditModal /> */}
      {/* <DeleteModal /> */}
    </Container>
  );
}

export default App;
