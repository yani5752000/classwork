import React from 'react';
import { Form, Button } from 'react-bootstrap'
import { Container, Row, Col } from 'react-bootstrap'

class SearchForm extends React.Component {
   render(){
    let { searchParameters, handleSubmit, handleSearchTermChange, handleSearchCategoryChange } = this.props;
    return (
          <Form onSubmit={handleSubmit}>
            <Container>
              <Row>
                <Col sm={2}>
                  <Button variant="primary" type="submit">
                      Search
                  </Button>
                </Col>
                <Col sm={4}>
                  <Form.Select aria-label="Default select example"
                  name="searchCategory"
                  onChange={handleSearchCategoryChange}>
                    <option>Search Category</option>
                    <option value="title">Title</option>
                    <option value="releaseYear">Release Year</option>
                    <option value="director">Director Name</option>
                    <option value="rating">Rating</option>
                  </Form.Select>
                </Col>
                <Col sm={6}>
                  <Form.Control type="text" placeholder="Search Term" name="searchTerm"
                  value={searchParameters.searchTerm} onChange={handleSearchTermChange} />
                </Col>
              </Row>
            </Container>
          </Form>
      )
   }
}

export default SearchForm