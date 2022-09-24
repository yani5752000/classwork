import React from 'react';
import { Form, Button, Modal } from 'react-bootstrap'

class EditModal extends React.Component {
  render() {
    let { dvdData, handleSubmit, handleChange, show, handleClose } = this.props;
    return (
      <Modal show={show} onHide={handleClose} animation={false}>
        <Modal.Dialog>
          <Modal.Header closeButton>
            <Modal.Title># {dvdData.id}</Modal.Title>
          </Modal.Header>

          <Modal.Body>
            <Form>
              <Form.Group controlId="dvdTitle">
                <Form.Label>Title:</Form.Label>
                <Form.Control type="text" placeholder="Title" name="title" 
                  onChange={handleChange}
                  value={dvdData.title} />
              </Form.Group>
              <Form.Group controlId="dvdReleaseYear">
                <Form.Label>Release Year:</Form.Label>
                <Form.Control type="text" placeholder="Release Year" name="releaseYear"
                  onChange={handleChange}
                  value={dvdData.releaseYear} />
              </Form.Group>
              <Form.Group controlId="dvdDirector">
                <Form.Label>Director:</Form.Label>
                <Form.Control type="text" placeholder="Director" name="director"
                  onChange={handleChange}
                  value={dvdData.director} />
              </Form.Group>
              <Form.Group controlId="dvdRating">
                    <Form.Label>Rating:</Form.Label>
                    <Form.Select aria-label="Default select example"
                    name="rating"
                    onChange={handleChange}
                    value={dvdData.rating}>
                      <option value="P">P</option>
                      <option value="G">G</option>
                      <option value="R">R</option>
                      <option value="PG">PG</option>
                      <option value="PG-13">PG-13</option>
                    </Form.Select>
                </Form.Group>
              <Form.Group controlId="dvdNotes">
                <Form.Label>Notes:</Form.Label>
                <Form.Control as="textarea" rows={3} placeholder="Notes" name="notes"
                  onChange={handleChange}
                  value={dvdData.notes} />
              </Form.Group>
            </Form>
          </Modal.Body>

          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>Close</Button>
            <Button variant="primary" 
            onClick={handleSubmit}
            value={dvdData.id}>Save changes</Button>
          </Modal.Footer>
        </Modal.Dialog>
      </Modal>
    )
  }
}

export default EditModal