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
    showCreateModal: false,
    dvdData: [
      {
        "dvdId": 1,
        "title": "hi0",
        "releaseYear": "2010",
        "director": "Janesen",
        "rating": "PG-10",
        "notes": "notes1"
      }],
      newDvdData: {
        "dvdId": 2,
        "title": "",
        "releaseYear": "",
        "director": "",
        "rating": "",
        "notes": "notes2"
      },
      newSearchParameters: {
        searchTerm: '',
        searchCategory: ''
      }
  }

  handleCreateFormChange = (event) => {
    // The event triggering this function should be an input's onChange event
    // We need to grab the input's name & value so we can associate it with the
    // newDvdData within the App's state.
    let inputName = event.target.name;
    let inputValue = event.target.value;
    let dvdInfo = this.state.newDvdData;

    console.log(`Updating new dvd data: ${inputName} : ${inputValue}`)

    if (dvdInfo.hasOwnProperty(inputName)) {
      dvdInfo[inputName] = inputValue;
      this.setState({ newDvdData: dvdInfo })
    }
  }

  handleCreateFormSubmit = (event) => {
    console.log("Adding dvd!")
    if (event) event.preventDefault();

    fetch(SERVICE_URL + '/dvd/', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(this.state.newDvdData),
    })
      .then(response => response.json())
      .then(data => {
        console.log('Add DVD - Success:', data);
        this.setState({ newDvdtData: { title: '', releaseYear: '', director: '', rating: '', notes: '' },
       showCreateModal: false })
        this.loadDvdData();
      })
      .catch((error) => {
        console.log('Add Contact - Error:')
        console.log(error)
      });
  }

  handleCreateModalClose = (event) => {
      console.log("Closing Create Modal")
      this.setState({ showCreateModal : false})
  }

  handleCreateModalOpen = (event) => {
      console.log("Opening Create Modal")
      if (event) event.preventDefault();
      console.log("Creating new DVD record")
      this.setState({ showCreateModal : true})
  }

  componentDidMount() {
    console.log("App is now mounted.")
    this.setState({ loading: true })
    console.log("Loading dvd data")
    this.loadDvdData();
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

    this.loadSearchedDvdData(this.state.newSearchParameters);
  }

  loadSearchedDvdData(parameters) {
    this.setState({ loading: true })
    console.log("Loading dvd data based on search category: " + parameters.searchCategory 
    + " and search term: " + parameters.searchTerm )
    fetch(SERVICE_URL + "/dvds")
      .then(data => data.json())
      .then(data => this.setState(
        { dvdData: data.filter(dvd => {return this.isMatch(dvd, parameters)}), loading: false }
      ))
  }

  isMatch(dvd, parameters) {
    if(typeof dvd[parameters.searchCategory] === "number") {
      return dvd[parameters.searchCategory] == parameters.searchTerm;
    } else {
      return dvd[parameters.searchCategory].includes(parameters.searchTerm);
    }
  }

  loadDvdData() {
    this.setState({ loading: true })
    console.log("Loading dvd data:");
    fetch(SERVICE_URL + "/dvds")
      .then(data => data.json())
      .then(data => {
        this.setState({ dvdData: data, loading: false });
      }
      )
  }

  render() {
    return (
      <Container fluid>
        <Row>
          <Col sm={4}>
            <CreateButton handleCreate={this.handleCreateModalOpen} />
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
        <CreateModal 
        handleSubmit={this.handleCreateFormSubmit}
        handleChange={this.handleCreateFormChange}
        show={this.state.showCreateModal}
        handleClose={this.handleCreateModalClose}
        dvdData={this.state.newDvdData} 
        />
        {/* <EditModal /> */}
        {/* <DeleteModal /> */}
      </Container>
    );
  }
}

export default App;