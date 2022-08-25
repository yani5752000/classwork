import React, { Component } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

class ProductHunt extends Component {
    constructor(props) {
        super(props);
        this.state = {
            chrono: 25,
            countingOn: false,
            countDowns: 0,
            pauses: 0,
            nIntervalId: null,
            products: [
                {
                    key: 1,
                    name: "turnip",
                    upvotes: 5,
                    downvotes: 6
                },
                {
                    key: 2,
                    name: "garlic",
                    upvotes: 11,
                    downvotes: 3
                },
                {
                    key: 3,
                    name: "onion",
                    upvotes: 8,
                    downvotes: 9
                }
            ],
            products1: this.reorder(this.state.products)
        };   

    }

    reorder = (array) => {
        const output = [];
        while(array.length > 0) {
            let index = this.getRandomInt(array.length);
            output.push(array[index]);
            array.splice(index, 1);
        }
        return output;
    }

    getRandomInt = (max) => {
        return Math.floor(Math.random() * max);
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
                {/* {this.state.chrono >= 0 && <h1>Timer: { this.state.chrono }</h1>}
                {this.state.chrono < 0 && <h1>Timer: 0</h1>}
                <h1>Count Downs: { this.state.countDowns }</h1>
                <h1>Pauses: { this.state.pauses }</h1> */}
                {/* <p>
                    It is a { this.state.color } { this.state.model } <br />
                    from { this.state.year }.
                </p> */}
                {/* <button id="start" type="button" onClick={this.start}>Start</button>
                <button id="stop" type="button" onClick={this.stop}>Stop</button> */}
                <div className="grid  md:grid-cols-2 lg:grid-cols-1 gap-4"  >
                    {this.state.products1.map(function (item) {
                    return (
                        // <card className="w-72 flex-1"  key={item.key}>
                        // <div>
                        //     <p className="capitalize">{item.name}</p>
                        //     <p>Upvotes: {item.upvotes}-Downvotes: {item.downvotes}</p>
                            
                        // </div>
                        // </card >
                        <div class="card" key={item.key}>
                        <div class="card-body">
                            <p class="capitalize">{item.name}</p>
                            <p>Upvotes: {item.upvotes}-Downvotes: {item.downvotes}</p>
                        </div>
                      </div>
                        // <div class="card" style="width: 18rem;">
                        // <img class="card-img-top" src="..." alt="Card image cap"></img>
                        // <div class="card-body">
                        // <h5 class="card-title">Card title</h5>
                        // <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        // <a href="#" class="btn btn-primary">Go somewhere</a>
                        // </div>
                        // </div>
                       
                    
                    );
                    })}
                </div>
            </div>
        );
    }
}

export default ProductHunt;