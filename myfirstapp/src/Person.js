import React, { Component } from 'react';

class Person extends Component {
    render() {
        const teacherName = 'Jonathan';
        return (
            <div>
                Hello {this.props.name}!
                <br/>
                Welcome to {teacherName}’s class!
            </div>
        );
    }
}

export default Person;