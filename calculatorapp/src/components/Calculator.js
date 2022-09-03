import React, { Component } from 'react';
import Card from "react-bootstrap/Card";
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import Button from "react-bootstrap/Button";
import "bootstrap/dist/css/bootstrap.min.css";

class Calculator extends Component {
    constructor(props) {
        super(props);
        this.state = {
            buttons: [
                {
                    key: 1,
                    name: 0
                },
                {
                    key: 2,
                    name: 1
                },
                {
                    key: 3,
                    name: 2
                },
                {
                    key: 4,
                    name: 3
                },
                {
                    key: 5,
                    name: 4
                },
                {
                    key: 6,
                    name: 5
                },
                {
                    key: 7,
                    name: 6
                },
                {
                    key: 8,
                    name: 7
                },
                {
                    key: 9,
                    name: 8
                },
                {
                    key: 10,
                    name: 9
                },
                {
                    key: 11,
                    name: "+",
                },
                {
                    key: 12,
                    name: "=",
                },
            ],
            orderedByUpvotes: false,
            output: null,
            value: null,
            firstOperandDone: false,
            secondOperandDone: false

        };   

    }

    reorder = () => {
        const array = [];
        for (const item of this.props.products) {
            array.push(item);
        }
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
    
    processButtonPress = () => {
        this.setState({output: 10});
    }

    handleClick = (e)=>{
        // console.log(e.target.value)
        this.setState({output: e.target.value});
      }

    // findMaxIndex = (arr) => {
    //     let max = 0;
        
    //     let maxIndex = 0;
        
    //     for(let i = 0; i < arr.length; i++) {
    //         if(arr[i].upvotes > max) {
    //             max = arr[i].upvotes;
    //             maxIndex = i;
    //         }
    //     }
    //     return maxIndex;
    // }

    // orderByUpvotes = () => {
    //     const arr = [];
    //     for (const item of this.state.products) {
    //         arr.push(item);
    //     }
    //     const output = [];
    //     while(arr.length > 0) {
            
            
    //         let maxIndex = this.findMaxIndex(arr);
           
    //         output.push(arr[maxIndex]);
            
    //         arr.splice(maxIndex, 1);
    //     }
        
    //     return output;
    // }

    // runOrderedByUpVotes = () => {
    //     this.setState({orderedByUpvotes: true});
    // }

   
    render() {
        return (
            <div className="flex flex-col items-center m-12"><p>Output: {this.state.output}</p>
                 <Button onClick={() => this.processButtonPress()} variant="primary">Button</Button>
                <section className="m-4">
                    <div className="grid  md:grid-cols-2 lg:grid-cols-3 gap-4"  >
                        <ButtonGroup onClick={this.handleClick}>
                            {this.state.buttons.map(function (item) {
                            return (
                                <Button key={item.key} variant="primary" value={item.name}>{item.name}</Button>
                            //     <Card style={{width:"20%"}} className="w-72 flex-1"  key={item.key}>
                            //     <Card.Body >
                            //         <Card.Title className="capitalize">{item.name}</Card.Title>
                                    
                            //         <Button variant="primary">More Details</Button>
                            //     </Card.Body>
                            //     </Card >
                            );
                            })}
                        </ButtonGroup>
                    </div>
                </section>
                    
                    
                

                
            </div>
        );
    }
}

export default Calculator;