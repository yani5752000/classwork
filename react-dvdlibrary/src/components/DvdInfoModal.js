import React from 'react';
import { Button, Modal } from 'react-bootstrap'

class DvdInfoModal extends React.Component {
  render() {
    let { dvdData, show, handleClose } = this.props;
    return (
      <Modal show={show} onHide={handleClose} animation={false}>
        <Modal.Dialog>
          <Modal.Body>
            <h4>{dvdData.title}</h4>
            <hr />
            <p>Release Year: {dvdData.releaseYear}</p>
            <p>Director: {dvdData.director}</p>
            <p>Rating: {dvdData.rating}</p>
            <p>Notes: {dvdData.notes}</p>
          </Modal.Body>

          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>Back</Button>
          </Modal.Footer>
        </Modal.Dialog>
      </Modal>
    )
  }
}

export default DvdInfoModal