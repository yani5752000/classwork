import React from 'react';

import DVDTable from './components/DVDTable';
import SerachForm from './components/SerachForm';
import CreateButton from './components/CreateButton';
import CreateModal from './components/CreateModal';
import EditModal from './components/EditModal';
import DeleteConfirmationModal from './components/DeleteConfirmationModal';
import DvdInfoModal from './components/DvdInfoModal';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';

const SERVICE_URL = "http://dvd-library.us-east-1.elasticbeanstalk.com/"

class App extends React.Component {

  state = {
    loading: false,
    showCreateModal: false,
    showEditModal: false,
    showDeleteConfirmationModal: false,
    showDvdInfoModal: false,
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
        "rating": "G",
        "notes": ""
      },
      editDvdData: {
        "id": 4,
        "title": "",
        "releaseYear": "",
        "director": "",
        "rating": "",
        "notes": "notes1ed"
      },
      showDvdData: {
        "id": 4,
        "title": "hi0ed",
        "releaseYear": "2011",
        "director": "Janeseed",
        "rating": "PG-10",
        "notes": "notes1ed"
      },
      searchFormErrors: {
        searchTerm: '',
        searchCategory: ''
      },
      toBeDeletedDvdId: "",
      newSearchParameters: {
        searchTerm: '',
        searchCategory: ''
      },
      showSearchFormErrorMessage: false,
      createFormErrors : {
        title : '',
        releaseYear : ''
      },
      createFormErrors : {
        title : '',
        releaseYear : ''
      },
      showCreateFormTitleErrorMessage: false,
      showCreateFormReleaseYearErrorMessage: false,
      editFormErrors : {
        title : '',
        releaseYear : ''
      },
      showEditFormTitleErrorMessage: false,
      showEditFormReleaseYearErrorMessage: false
  }

  validateDvd = (dvd) => {
    console.log("validate for edit submit: ", dvd);
    let errors = {
      title : "",
      releaseYear: "",
      isValid: true
    }

    let isInvalid = false;

    if(!dvd.title){
      errors.title = "Please enter a title."
      errors.isValid = false;
    }

    if(!dvd.releaseYear){
      errors.releaseYear = "Please enter a release year."
      errors.isValid = false;
    }

    let releaseYearPattern = "[0-9]{4}";
    if(dvd.releaseYear && !dvd.releaseYear.match(releaseYearPattern)){
      errors.releaseYear = "Please match the expected pattern."
      errors.isValid = false;
    }

    return errors;
  }

  validateSearch = (search) => {
    let errors = {
      searchCategory : "",
      searchTerm: "",
      isValid: true
    }

    let isInvalid = false;

    if(!search.searchCategory){
      errors.searchCategory = "Please select a category."
      errors.isValid = false;
    }

    if(!search.searchTerm){
      errors.searchTerm = "Please enter a search term."
      errors.isValid = false;
    }
    return errors;
  }

  handleDvdInfoModalClose = (event) => {
    console.log("Closing Dvd Info Modal")
    this.setState({ showDvdInfoModal: false })
  }
  
  handleDvdInfoModalOpen = (event) => {
    console.log("Opening Dvd Info Modal")
    if (event) event.preventDefault();
    let dvdId = event.target.value;
    console.log(`showing dvd id ${dvdId}`);
    // submit a GET request to the /dvd/{dvdId} endpoint
      // the response should come back with the associated dvd's JSON
      fetch(SERVICE_URL+'/dvd/'+dvdId)
      .then(response => response.json())
      .then(data => {
          console.log('Success:', data);
          this.setState(
            { showDvdData : data , showDvdInfoModal : true}
          )
      })
      .catch((error) => {
          console.error('Error:', error);
      });

  }

  handleDeleteDvd = (event) => {
    if (event) event.preventDefault();
    let dvdId = this.state.toBeDeletedDvdId;
    console.log(`Submitting delete for dvd id ${dvdId}`)

    fetch(SERVICE_URL+'/dvd/'+dvdId, {
        method: 'DELETE',
    })
    .then(data => {
        this.setState({toBeDeletedDvdId: "", showDeleteConfirmationModal: false});
        this.loadDvdData();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

handleDeleteConfirmationModalClose = (event) => {
  console.log("Closing Delete Confirmation Modal")
  this.setState({ showDeleteConfirmationModal : false, toBeDeletedDvdId: ""})
}

handleDeleteConfirmationModalOpen = (event) => {
  console.log("Opening Delete Confirmation Modal")
  if (event) event.preventDefault();
  this.setState({toBeDeletedDvdId: event.target.value});
  console.log(`Attempting deleting dvd id ${this.state.toBeDeletedDvdId}`);
  this.setState({showDeleteConfirmationModal: true});
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
          data.releaseYear = data.releaseYear + "";
          data.rating = "G";
          this.setState(
            { editDvdData : data , showEditModal : true}
          );
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

handleEditFormSubmit = (event) => {
  if (event) event.preventDefault();
  // let dvdId = event.target.value;
  let dvdId = this.state.editDvdData.id;
  console.log(`Submitting edit for dvd id ${dvdId}`)
  console.log(this.state.editDvdData)

  this.setState({showEditFormTitleErrorMessage: false,
  showEditFormReleaseYearErrorMessage: false})

  let validationErrors = this.validateDvd(this.state.editDvdData)
  console.log("editsubmit validation errors: ", validationErrors);
  if(!validationErrors.isValid){
    console.log("Edited DVD is invalid. Reporting errors.", validationErrors)
    this.setState({editFormErrors : validationErrors});
    if(validationErrors.title) {
      this.setState({showEditFormTitleErrorMessage: true});
    }
    if(validationErrors.releaseYear) {
      this.setState({showEditFormReleaseYearErrorMessage: true});
    }
    return
  }

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
      
      this.setState({ 
      showEditFormTitleErrorMessage: false,
      showEditFormReleaseYearErrorMessage: false,
      showEditModal: false,
      EditFormErrors: validationErrors
     })
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

    this.setState({showCreateFormTitleErrorMessage: false,
    showCreateFormReleaseYearErrorMessage: false})

    let validationErrors = this.validateDvd(this.state.newDvdData)
    if(!validationErrors.isValid){
      console.log("The new DVD is invalid. Reporting errors.", validationErrors)
      this.setState({createFormErrors : validationErrors});
      if(validationErrors.title) {
        this.setState({showCreateFormTitleErrorMessage: true});
      }
      if(validationErrors.releaseYear) {
        this.setState({showCreateFormReleaseYearErrorMessage: true});
      }
      return
    }

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
        this.setState({ newDvdData: {
          "title": "",
          "releaseYear": "",
          "director": "",
          "rating": "G",
          "notes": ""
        },
        showCreateFormTitleErrorMessage: false,
        showCreateFormReleaseYearErrorMessage: false,
        showCreateModal: false,
        createFormErrors: validationErrors
       })
        this.loadDvdData();
      })
      .catch((error) => {
        console.log('Add Contact - Error:')
        console.log(error)
      });

  }

  handleCreateModalClose = (event) => {
      console.log("Closing Create Modal")
      this.setState({ showCreateModal : false,
        newDvdData: {
          "title": "",
          "releaseYear": "",
          "director": "",
          "rating": "G",
          "notes": ""
        } })
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

    let validationErrors = this.validateSearch(this.state.newSearchParameters)
    if(!validationErrors.isValid){
      console.log("The search is invalid. Reporting errors.", validationErrors)
      this.setState({searchFormErrors : validationErrors,
      showSearchFormErrorMessage: true})
      return
    }

    this.loadSearchedDvdData(this.state.newSearchParameters);
    this.setState({searchFormErrors: validationErrors,
      showSearchFormErrorMessage: false,
      newSearchParameters: {
        searchTerm: '',
        searchCategory: ''
      }})
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
            searchParameters={this.state.newSearchParameters}
            searchErrors={this.state.searchFormErrors} />
            {this.state.showSearchFormErrorMessage 
            && <div className="border border-dark w-50 p-3"
            style={{backgroundColor: "rgba(255, 0, 0, 0.1)"}}
            >Both Search Category and Search Term are required.</div>
            }
          </Col>
        </Row>
        <hr />
        <Row>
          <Col className="text-center">
            <DVDTable 
            handleOpenDialog={this.handleDeleteConfirmationModalOpen}
            handleEdit={this.handleEditModalOpen}
            handleShow={this.handleDvdInfoModalOpen}
            dvds={this.state.dvdData} />
          </Col>
        </Row>
        <hr />
        <CreateModal 
        dvdErrors={this.state.createFormErrors}
        showCreateFormTitleErrorMessage={this.state.showCreateFormTitleErrorMessage}
        showCreateFormReleaseYearErrorMessage={this.state.showCreateFormReleaseYearErrorMessage}
        handleSubmit={this.handleCreateFormSubmit}
        handleChange={this.handleCreateFormChange}
        show={this.state.showCreateModal}
        handleClose={this.handleCreateModalClose}
        dvdData={this.state.newDvdData} 
        />
        <EditModal
         dvdErrors={this.state.editFormErrors}
         showEditFormTitleErrorMessage={this.state.showEditFormTitleErrorMessage}
         showEditFormReleaseYearErrorMessage={this.state.showEditFormReleaseYearErrorMessage}
         handleSubmit={this.handleEditFormSubmit}
         handleChange={this.handleEditFormChange}
         show={this.state.showEditModal}
         handleClose={this.handleEditModalClose}
         dvdData={this.state.editDvdData} />
        <DeleteConfirmationModal 
        handleSubmit={this.handleDeleteDvd}
        show={this.state.showDeleteConfirmationModal}
        handleClose={this.handleDeleteConfirmationModalClose}/>
        <DvdInfoModal 
        show={this.state.showDvdInfoModal}
        handleClose={this.handleDvdInfoModalClose}
        dvdData={this.state.showDvdData} />
      </Container>
    );
  }
}

export default App;