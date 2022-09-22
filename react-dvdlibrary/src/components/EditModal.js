import React from 'react';
import { Form, Button, Modal } from 'react-bootstrap'

class EditModal extends React.Component {
  render() {
    let { dvdData, show, handleClose } = this.props;
    return (
      <Modal show={show} onHide={handleClose} animation={false}>
        <Modal.Dialog>
          <Modal.Header closeButton>
            <Modal.Title># {dvdData.dvdId}</Modal.Title>
          </Modal.Header>

          <Modal.Body>
            <Form>
              <Form.Group controlId="dvdTitle">
                <Form.Label>Title:</Form.Label>
                <Form.Control type="text" placeholder="Title" name="title"
                  value={contactData.firstName} />
              </Form.Group>
              <Form.Group controlId="contactLastName">
                <Form.Label>Last Name:</Form.Label>
                <Form.Control type="text" placeholder="Last Name" name="lastName"
                  value={contactData.lastName} />
              </Form.Group>
              <Form.Group controlId="contactCompany">
                <Form.Label>Company:</Form.Label>
                <Form.Control type="text" placeholder="Company" name="company"
                  value={contactData.company} />
              </Form.Group>
              <Form.Group controlId="contactPhone">
                <Form.Label>Phone Number:</Form.Label>
                <Form.Control type="phone" placeholder="Phone Number" name="phone"
                  value={contactData.phone} />
              </Form.Group>
              <Form.Group controlId="contactEmail">
                <Form.Label>Email:</Form.Label>
                <Form.Control type="email" placeholder="Email" name="email"
                  value={contactData.email} />
              </Form.Group>
            </Form>
          </Modal.Body>

          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>Close</Button>
            <Button variant="primary" value={contactData.contactId}>Save changes</Button>
          </Modal.Footer>
        </Modal.Dialog>
      </Modal>
    )
  }
}

export default ContactModal