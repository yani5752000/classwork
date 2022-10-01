import React from 'react';
import { Form, Button, Modal, Label } from 'react-bootstrap'

class EditModal extends React.Component {
  render() {
    let { dvdData, dvdErrors, handleSubmit, handleChange, show, handleClose,
      showEditFormTitleErrorMessage,
      showEditFormReleaseYearErrorMessage } = this.props;
    return (
      <Modal show={show} onHide={handleClose} animation={false}>
        <Modal.Dialog>
          <Modal.Header closeButton>
            <Modal.Title># {dvdData.id}</Modal.Title>
          </Modal.Header>

          <Modal.Body>
            {this.props.showEditFormTitleErrorMessage 
              && <div className="border border-dark w-100 p-3"
              style={{backgroundColor: "rgba(255, 0, 0, 0.1)"}}
              >Please enter a title for the DVD.</div>
              }
            {this.props.showEditFormReleaseYearErrorMessage
              && <div className="border border-dark w-100 p-3"
              style={{backgroundColor: "rgba(255, 0, 0, 0.1)"}}
              >Please enter a 4-digit year.</div>
              }
            <Form onSubmit={handleSubmit}>
              <Form.Group controlId="dvdTitle">
                <Form.Label>Title:</Form.Label>
                <Form.Control type="text" placeholder="Title" name="title" 
                  onChange={handleChange}
                  value={dvdData.title}
                  isInvalid={!!dvdErrors.title}/>
              </Form.Group>
              {/* <Form.Group controlId="dvdReleaseYear">
                <Form.Label>Release Year:</Form.Label>
                <Form.Control type="text" placeholder="Release Year" name="releaseYear"
                  onChange={handleChange}
                  value={dvdData.releaseYear} 
                  isInvalid={!!dvdErrors.releaseYear}/>
                <Form.Text className="text-muted">
                    Format Example: 1567
                </Form.Text>
              </Form.Group> */}
              <Form.Group controlId="dvdReleaseYear">
                    <Form.Label>Release Year:</Form.Label>
                    <Form.Control type="text" placeholder="Release Year" name="releaseYear"
                    value={dvdData.releaseYear} onChange={handleChange}
                    isInvalid={!!dvdErrors.releaseYear}/>
                    <Form.Text className="text-muted">
                        Format Example: 1567
                    </Form.Text>
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
                    value={dvdData.rating}
                    >
                      <option value="G">G</option>
                      <option value="P">P</option>
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
                <Button variant="primary" type="submit" value={dvdData.id}>
                Save changes
                </Button>
                <Button variant="secondary" onClick={handleClose}>Close</Button>
            </Form>
          </Modal.Body>

          <Modal.Footer>
            {/* <Button variant="secondary" onClick={handleClose}>Close</Button>
            <Button variant="primary" 
            onClick={handleSubmit}
            value={dvdData.id}>Save changes</Button> */}
          </Modal.Footer>
        </Modal.Dialog>
      </Modal>
    )
  }
}

export default EditModal