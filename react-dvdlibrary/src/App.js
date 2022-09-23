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
    showEditModal: false,
    dvdData: [
      {
        "id": 1,
        "title": "hi0",
        "releaseYear": "2010",
        "director": "Janesen",
        "rating": "PG-10",
        "notes": "notes1"
      }],
      newDvdData: {
        "title": "",
        "releaseYear": "",
        "director": "",
        "rating": "",
        "notes": "notes2"
      },
      editDvdData: {
        "id": 4,
        "title": "hi0ed",
        "releaseYear": "2011",
        "director": "Janeseed",
        "rating": "PG-10",
        "notes": "notes1ed"
      },
      newSearchParameters: {
        searchTerm: '',
        searchCategory: ''
      }
  }

  handleEditModalClose = (event) => {
    console.log("Closing Edit Modal")
    this.setState({ showEditModal : false})
}

handleEditModalOpen = (event) => {
    console.log("Opening Edit Modal")
    if (event) event.preventDefault();
    let dvdId = event.target.value;
    console.log(`Editing dvd id ${dvdId}`);
    // submit a GET request to the /dvd/{dvdId} endpoint
      // the response should come back with the associated dvd's JSON
      fetch(SERVICE_URL+'/dvd/'+dvdId)
      .then(response => response.json())
      .then(data => {
          console.log('Success:', data);
          this.setState(
            { editDvdData : data , showEditModal : true}
          )
      })
      .catch((error) => {
          console.error('Error:', error);
      });
}

handleEditFormChange = (event) => {

  let inputName = event.target.name;
  let inputValue = event.target.value;
  let dvdInfo = this.state.editDvdData;
  console.log("Changer: ", dvdInfo);

  console.log(`Something changed in ${inputName} : ${inputValue}`)

  if(dvdInfo.hasOwnProperty(inputName)){
      dvdInfo[inputName] = inputValue;
      this.setState({ editDvdData : dvdInfo })
  }

}

// handleEditFormSubmit = (event) => {
//   if (event) event.preventDefault();
//   let dvdId = event.target.value;
//   console.log(`Submitting edit for dvd id ${dvdId}`)
//   console.log(this.state.editDvdData)

//   fetch(SERVICE_URL+'/dvd/'+dvdId, {
//       method: 'PUT',
//       headers: {
//           'Content-Type': 'application/json',
//       },
//       body: JSON.stringify(this.state.editDvdData),
//   })
//   .then(response => response.json())
//   .then(data => {
//       console.log('Success:', data);
//       this.setState({ showEditModal : false })
//       this.loadContactData();
//   })
//   .catch((error) => {
//       console.error('Error:', error);
//   });

// }

handleEditFormSubmit = (event) => {
  if (event) event.preventDefault();
  let dvdId = event.target.value;
  console.log(`Submitting edit for dvd id ${dvdId}`)
  // let dvdInfo = this.state.editDvdData;
  // dvdInfo.id = dvdId;
  // this.setState({ editDvdData : dvdInfo })
  console.log(this.state.editDvdData)

  // let validationErrors = this.validateContact(this.state.editContactData)
  // if(!validationErrors.isValid){
  //   console.log("Edited contact is invalid. Reporting errors.")
  //   this.setState({editFormErrors : validationErrors})
  //   return
  // }

  fetch(SERVICE_URL + '/dvd/' + dvdId, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(this.state.editDvdData),
  })
    .then(response => console.log("respppp: ", response))
    .then(data => {
      console.log('Success:', data);
      this.setState({ showEditModal: false})
      this.loadDvdData();
    })
    .catch((error) => {
      console.error('Error:', error);
    });

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
        console.log("dvdData: ", this.state.dvdData);
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
            <DVDTable 
            handleEdit={this.handleEditModalOpen}
            dvds={this.state.dvdData} />
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
        <EditModal
         handleSubmit={this.handleEditFormSubmit}
         handleChange={this.handleEditFormChange}
         show={this.state.showEditModal}
         handleClose={this.handleEditModalClose}
         dvdData={this.state.editDvdData} />
        {/* <DeleteModal /> */}
      </Container>
    );
  }
}

export default App;