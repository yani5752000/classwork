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
                    key: 11,
                    name: "-",
                },
                {
                    key: 11,
                    name: "x",
                },
                {
                    key: 11,
                    name: "/",
                },
                {
                    key: 12,
                    name: "=",
                },
                {
                    key: 12,
                    name: "C",
                }
            ],
            orderedByUpvotes: false,
            output: "",
            number1: 0,
            number2: 0,
            firstOperandDone: false,
            secondOperandDone: false,
            operation: null,
            inTheEnd: false
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
    
    processButtonPress = (e) => {
        this.setState({inTheEnd: false});
        if(e.target.value === "C") {
            this.setState({output: ""});
            this.setState({firstOperandDone: false});
            this.setState({secondOperandDone: false,
                number1: 0,
                number2: 0
            });
            return;
        }
        console.log("hi1");
        // let operation;
        // this.setState({output: e.target.value});
        if(!this.state.firstOperandDone && !this.isOperator( e.target.value )){
            console.log("hi2");
            this.setState({number1: Number(e.target.value) + 10 * this.state.number1});
            this.setState({output: this.state.output + e.target.value});
            
        } 
        if(this.state.firstOperandDone && !this.isOperator( e.target.value ) && e.target.value !== "=") {
            console.log("hi3");
            this.setState({number2: Number(e.target.value) + 10 * this.state.number2});
            this.setState({output: this.state.output + e.target.value});
           
        }

        if(this.isOperator(e.target.value)) {
            console.log("hi4");
            this.setState({operation: e.target.value});
            // console.log("operation: ", operation);
            // console.log("type: ", typeof operation);
            this.setState({firstOperandDone: true});
            this.setState({output: this.state.output + e.target.value});
        }

        // console.log("1operaion ", operation);

        if(e.target.value === "=") {
            // console.log("2operaion ", operation);
            console.log("hi5");
            this.setState({secondOperandDone: true});
            this.setState({result: this.operate(this.state.number1, this.state.number2, this.state.operation)})
            this.setState({output: ""});
            this.setState({firstOperandDone: false});
            this.setState({secondOperandDone: false});
            this.setState({number1: 0});
            this.setState({number2: 0});
            this.setState({inTheEnd: true});

        }
        
    }

    isOperator = (c) => {
        return c === "+" || c === "-" || c === "x" || c === "/";
    }

    operate = (a, b, op) => {
        console.log("hi6");
        console.log("OP ", op);
        console.log("ty: ", typeof op);
        switch(op) {
            case '+': console.log("hi7"); 
                        return a + b;
            case '-': return a - b;
            case 'x': return a * b;
            case '/': return a / b;
        }
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
            <div className="flex flex-col items-center m-12">
                {this.state.inTheEnd && <p>Output: {this.state.result}</p>}
                {!this.state.inTheEnd && <p>Output: {this.state.output}</p>}
                
                <section className="m-4">
                    
                    <ButtonGroup onClick={this.processButtonPress} className = "grid  md:grid-cols-2 lg:grid-cols-3 gap-4">
                        <div className="grid  md:grid-cols-2 lg:grid-cols-3 gap-4"  >
                            {this.state.buttons.map(function (item) {
                            return (
                                <Button className="w-72 flex-1" key={item.key} variant="primary" value={item.name}>{item.name}</Button>
                            //     <Card style={{width:"20%"}} className="w-72 flex-1"  key={item.key}>
                            //     <Card.Body >
                            //         <Card.Title className="capitalize">{item.name}</Card.Title>
                                    
                            //         <Button variant="primary">More Details</Button>
                            //     </Card.Body>
                            //     </Card >
                            );
                            })}
                        </div>
                    </ButtonGroup>
                    
                </section>
                    
                    
                

                
            </div>
        );
    }
}

export default Calculator;