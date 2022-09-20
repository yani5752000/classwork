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
      }],
      newSearchParameters: {
        searchTerm: '',
        searchCategory: ''
      }
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

  handleSearchTermChange = (event) => {
    // The event triggering this function should be an input's onChange event
    // We need to grab the input's name & value so we can associate it with the
    // searchParameters within the App's state.
    let inputName = event.target.name;
    let inputValue = event.target.value;
    let searchParamsInfo = this.state.newSearchParameters;

    console.log(`Updating new search parameters: ${inputName} : ${inputValue}`)

    if (searchParamsInfo.hasOwnProperty(inputName)) {
      searchParamsInfo[inputName] = inputValue;
      this.setState({ newSearchParameters: searchParamsInfo })
    }
  }

  handleSearchCategoryChange = (event) => {
    // The event triggering this function should be an input's onChange event
    // We need to grab the input's name & value so we can associate it with the
    // searchParameters within the App's state.
    let inputName = event.target.name;
    let inputValue = event.target.value;
    let searchParamsInfo = this.state.newSearchParameters;

    console.log(`Updating new search parameters: ${inputName} : ${inputValue}`)

    if (searchParamsInfo.hasOwnProperty(inputName)) {
      searchParamsInfo[inputName] = inputValue;
      this.setState({ newSearchParameters: searchParamsInfo })
    }
  }

  handleSearchFormSubmit = (event) => {
    console.log("processing the search!")
    if (event) event.preventDefault();

    this.loadDvdData(this.state.newSearchParameters);
  }

  loadDvdData(parameters) {
    this.setState({ loading: true })
    console.log("Loading dvd data based on search category: " + parameters.searchCategory 
    + " and search term: " + parameters.searchTerm )
    fetch(SERVICE_URL + "/dvds")
      .then(data => data.json())
      .then(data => this.setState(
        { dvdData: data.filter(dvd => {return dvd[parameters.searchCategory].includes(parameters.searchTerm)}), loading: false }
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
            <SerachForm 
            handleSubmit={this.handleSearchFormSubmit}
            handleSearchTermChange={this.handleSearchTermChange}
            handleSearchCategoryChange={this.handleSearchCategoryChange}
            searchParameters={this.state.newSearchParameters} />
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