import React, { Component } from 'react';

class Car extends Component {
    constructor(props) {
        super(props);
        this.state = {
            brand: "Ford",
            model: "Mustang",
            color: "Cherry Red",
            year: "2019"
        };
    }
    changeColor = () => {
        //alert("I will now change colors...");
        if(this.state.color === "Cherry Red") {
            this.setState({color: "Velocity Blue"});
        } else {
            this.setState({color: "Cherry Red"});
        }

    }
    render() {
        return (
            <div>
                <h1>My { this.state.brand }</h1>
                <p>
                    It is a { this.state.color } { this.state.model } <br />
                    from { this.state.year }.
                </p>
                <button id="changeColor" type="button" onClick={this.changeColor}>Change Color</button>
            </div>
        );
    }
}

export default Car;