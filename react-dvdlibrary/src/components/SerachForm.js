import React from 'react';
import { Form, Button } from 'react-bootstrap'
import { Container, Row, Col } from 'react-bootstrap'

class SearchForm extends React.Component {
   render(){
    let { searchParameters, searchErrors, handleSubmit, handleSearchTermChange, handleSearchCategoryChange } = this.props;
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
                  <Form.Group>
                    {/* <Form.Control as="select"
                    name="searchCategory"
                    value={searchParameters.searchCategory}
                    onChange={handleSearchCategoryChange}
                    isInvalid={!!searchErrors.searchCategory}>
                      <option>Search Category</option>
                      <option value="title">Title</option>
                      <option value="releaseYear">Release Year</option>
                      <option value="director">Director Name</option>
                      <option value="rating">Rating</option>
                    </Form.Control> */}
                    {/* <Form.Control.Feedback type="invalid">
                      {searchErrors.searchCategory}
                    </Form.Control.Feedback> */}
                    <Form.Select aria-label="Default select example"
                    name="searchCategory"
                    value={searchParameters.searchCategory}
                    onChange={handleSearchCategoryChange}
                    isInvalid={!!searchErrors.searchCategory}>
                      <option>Search Category</option>
                      <option value="title">Title</option>
                      <option value="releaseYear">Release Year</option>
                      <option value="director">Director Name</option>
                      <option value="rating">Rating</option>
                    </Form.Select>
                  </Form.Group>
                </Col>
                <Col sm={6}>
                  <Form.Group>
                    <Form.Control type="text" placeholder="Search Term" name="searchTerm"
                    value={searchParameters.searchTerm} onChange={handleSearchTermChange} 
                    isInvalid={!!searchErrors.searchTerm} />
                    {/* <Form.Control.Feedback type="invalid">
                      {searchErrors.searchTerm}
                    </Form.Control.Feedback> */}
                  </Form.Group>
                </Col>
              </Row>
            </Container>
          </Form>
      )
   }
}

export default SearchForm