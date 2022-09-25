import React from 'react';
import { Table, Button } from 'react-bootstrap'

const DVDTableHeader = () => {
  return (
      <tr>
          <th>Title</th>
          <th>Release Year</th>
          <th>Director</th>
          <th>Rating</th>
          <th></th>
          <th></th>
      </tr>
  );
}

const DVDTableRow = ({ dvd, toggleEdit, toggleOpen, toggleShow }) => {
  return (
      <tr>
          <td><Button onClick={toggleShow} 
          value={dvd.id}
          className="btn btn-link"
          >{dvd.title}</Button></td>
          <td>{dvd.releaseYear}</td>
          <td>{dvd.director}</td>
          <td>{dvd.rating}</td>
          <td><Button onClick={toggleEdit} value={dvd.id}>Edit</Button></td>
          <td><Button onClick={toggleOpen} value={dvd.id}>Delete</Button></td>
      </tr>
  );
}

class DVDTable extends React.Component {
  // this static property will initialize a prop with data
    // if it hasn't been provided by the parent component
    static defaultProps = {
        dvds: [
            {
                "title": "hi1",
                "releaseYear": "2014",
                "director": "Jones",
                "rating": "PG"
            },
            {
              "title": "hi2",
              "releaseYear": "2012",
              "director": "Janes",
              "rating": "PG-13"
            }
        ]
    }


  render() {
      return (<Table striped bordered responsive>
          <thead>
              <DVDTableHeader />
          </thead>
          <tbody>
              {this.props.dvds.map((dvd, i) => {
                  return <DVDTableRow dvd={dvd} key={i} 
                  toggleEdit={this.props.handleEdit}
                  toggleOpen={this.props.handleOpenDialog}
                  toggleShow={this.props.handleShow}/>
              })}
          </tbody>
      </Table>)
  }
}

export default DVDTable