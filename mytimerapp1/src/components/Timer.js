import React, { Component } from 'react';

class Timer extends Component {
    constructor(props) {
        super(props);
        this.state = {
            chrono: 25,
            countingOn: false,
            countDowns: 0,
            pauses: 0,
            nIntervalId: null
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

    start = () => {
        this.setState({nIntervalId: setInterval(
            () => {
                if(this.state.chrono > -5) {
                    if(this.state.chrono === 0) {
                        this.setState({countDowns: this.state.countDowns + 1});
                    }
                    this.setState({chrono: this.state.chrono - 1});
                } else {
                    this.setState({pauses: this.state.pauses + 1});
                    this.setState({chrono: 25});
                }
            }
            , 1000
        )});
    }

    stop = () => {
        clearInterval(this.state.nIntervalId);
        this.setState({nIntervalId: null});
    }
    render() {
        return (
            <div>
                {this.state.chrono >= 0 && <h1>{ this.state.chrono }</h1>}
                {this.state.chrono < 0 && <h1>0</h1>}
                <h1>Count Downs: { this.state.countDowns }</h1>
                <h1>Pauses { this.state.pauses }</h1>
                {/* <p>
                    It is a { this.state.color } { this.state.model } <br />
                    from { this.state.year }.
                </p> */}
                <button id="start" type="button" onClick={this.start}>Start</button>
                <button id="stop" type="button" onClick={this.stop}>Stop</button>
            </div>
        );
    }
}

export default Timer;