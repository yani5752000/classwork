import React from 'react';
import { Button, Modal } from 'react-bootstrap'

class DeleteConfirmationModal extends React.Component {
  render() {
    let { handleSubmit, show, handleClose } = this.props;
    return (
        <Modal show={show} onHide={handleClose} animation={false}>
        <Modal.Dialog>
          <Modal.Header closeButton>
            <Modal.Title>Confirmation</Modal.Title>
          </Modal.Header>

          <Modal.Body>
            Are you sure you want to delete this dvd from your collection?
          </Modal.Body>

          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>Cancel</Button>
            <Button variant="primary" 
            onClick={handleSubmit}>Yes</Button>
          </Modal.Footer>
        </Modal.Dialog>
      </Modal>
    )
  }
}
export default DeleteConfirmationModal