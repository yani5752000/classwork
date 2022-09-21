import React from 'react';
import { Form, Button, Modal } from 'react-bootstrap'

class ContactModal extends React.Component {
  render() {
    let { dvdData, show, handleClose, handleChange } = this.props;
    return (
      <Modal show={show} onHide={handleClose} animation={false}>
        <Modal.Dialog>
          {/* <Modal.Header closeButton>
            <Modal.Title># {contactData.contactId}</Modal.Title>
          </Modal.Header> */}

          <Modal.Body>
          <Form>
                <Form.Group controlId="dvdTitle">
                    <Form.Label>Title:</Form.Label>
                    <Form.Control type="text" placeholder="Title" name="title"
                    value={dvdData.title} onChange={handleChange}/>
                </Form.Group>
                <Form.Group controlId="dvdReleaseYear">
                    <Form.Label>Release Year:</Form.Label>
                    <Form.Control type="text" placeholder="Release Year" name="releaseYear"
                    value={dvdData.releaseYear} onChange={handleChange}/>
                </Form.Group>
                <Form.Group controlId="dvdDirector">
                    <Form.Label>Director:</Form.Label>
                    <Form.Control type="text" placeholder="Director" name="director"
                    value={dvdData.director} onChange={handleChange}/>
                </Form.Group>
                <Form.Group controlId="dvdRating">
                    <Form.Label>Phone Number:</Form.Label>
                    <Form.Control type="text" placeholder="Rating" name="rating"
                    value={dvdData.rating} onChange={handleChange}/>
                </Form.Group>
                <Form.Group controlId="dvdNotes">
                    <Form.Label>Notes:</Form.Label>
                    <Form.Control type="text" placeholder="Notes" name="notes"
                    value={dvdData.notes} onChange={handleChange}/>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
          </Modal.Body>

          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>Close</Button>
            {/* <Button variant="primary" value={contactData.contactId}>Save changes</Button> */}
          </Modal.Footer>
        </Modal.Dialog>
      </Modal>
    )
  }
}

export default ContactModal