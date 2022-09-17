import React from 'react';

import DVDTable from './components/DVDTable';
import SerachForm from './components/SerachForm';
import CreateButton from './components/CreateButton';
import CreateModal from './components/CreateModal';
import DeleteModal from './components/DeleteModal';
import EditModal from './components/EditModal';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';

const SERVICE_URL = "http://dvd-library.us-east-1.elasticbeanstalk.com/"

class App extends React.Component {

  state = {
    loading: false,
    dvdData: [
      {
        "title": "hi0",
        "releaseYear": "2010",
        "director": "Janesen",
        "rating": "PG-10"
      }]
  }

  componentDidMount() {
    console.log("App is now mounted.")
    this.setState({ loading: true })
    console.log("Loading dvd data")
    fetch(SERVICE_URL + "/dvds")
      .then(data => data.json())
      .then(data => this.setState(
        { dvdData: data, loading: false }
      ))
  }

  render() {
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
            <DVDTable dvds={this.state.dvdData} />
          </Col>
        </Row>
        <hr />
        {/* <CreateModal /> */}
        {/* <EditModal /> */}
        {/* <DeleteModal /> */}
      </Container>
    );
  }
}

export default App;