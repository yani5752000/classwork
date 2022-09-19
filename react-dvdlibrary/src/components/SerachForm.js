import React from 'react';
import { Form, Button } from 'react-bootstrap'
import { Container, Row, Col } from 'react-bootstrap'

class SearchForm extends React.Component {
   render(){
    return (
          <Form>
            <Container>
              <Row>
                <Col sm={2}>
                  <Button variant="primary" type="submit">
                      Search
                  </Button>
                </Col>
                <Col sm={4}>
                  <Form.Select aria-label="Default select example">
                    <option>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                  </Form.Select>
                </Col>
                <Col sm={6}>
                  <Form.Control type="text" placeholder="Search Term" name="keyword"/>
                </Col>
              </Row>
            </Container>
          </Form>
      )
   }
}

export default SearchForm