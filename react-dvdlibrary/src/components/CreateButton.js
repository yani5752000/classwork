import React from 'react';
import { Button } from 'react-bootstrap';

class CreateButton extends React.Component {
  render() {
    return (
      <Button onClick={this.props.handleCreate}>Create</Button>
    )
  }
}
export default CreateButton
  
