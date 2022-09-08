import React, { Component } from 'react';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import Button from "react-bootstrap/Button";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/css/bootstrap.css";

class Calculator extends Component {
    constructor(props) {
        super(props);
        // this.state = {
        //     buttons: [
        //         {
        //             key: 1,
        //             name: 0
        //         },
        //         {
        //             key: 2,
        //             name: 1
        //         },
        //         {
        //             key: 3,
        //             name: 2
        //         },
        //         {
        //             key: 4,
        //             name: 3
        //         },
        //         {
        //             key: 5,
        //             name: 4
        //         },
        //         {
        //             key: 6,
        //             name: 5
        //         },
        //         {
        //             key: 7,
        //             name: 6
        //         },
        //         {
        //             key: 8,
        //             name: 7
        //         },
        //         {
        //             key: 9,
        //             name: 8
        //         },
        //         {
        //             key: 10,
        //             name: 9
        //         },
        //         {
        //             key: 11,
        //             name: "+",
        //         },
        //         {
        //             key: 11,
        //             name: "-",
        //         },
        //         {
        //             key: 11,
        //             name: "x",
        //         },
        //         {
        //             key: 11,
        //             name: "/",
        //         },
        //         {
        //             key: 12,
        //             name: "=",
        //         },
        //         {
        //             key: 12,
        //             name: "C",
        //         }
        //     ],
        //     output: "",
        //     number1: 0,
        //     number2: 0,
        //     firstOperandDone: false,
        //     secondOperandDone: false,
        //     operation: null,
        //     inTheEnd: false
        // };   

    }
    
    // processButtonPress = (e) => {
    //     this.setState({inTheEnd: false});
    //     if(e.target.value === "C") {
    //         this.setState({output: ""});
    //         this.setState({firstOperandDone: false});
    //         this.setState({secondOperandDone: false,
    //             number1: 0,
    //             number2: 0
    //         });
    //         return;
    //     }
    //     if(!this.state.firstOperandDone && !this.isOperator( e.target.value )){
    //         console.log("hi2");
    //         this.setState({number1: Number(e.target.value) + 10 * this.state.number1});
    //         this.setState({output: this.state.output + e.target.value});
            
    //     } 
    //     if(this.state.firstOperandDone && !this.isOperator( e.target.value ) && e.target.value !== "=") {
    //         console.log("hi3");
    //         this.setState({number2: Number(e.target.value) + 10 * this.state.number2});
    //         this.setState({output: this.state.output + e.target.value});
           
    //     }

    //     if(this.isOperator(e.target.value)) {
    //         this.setState({operation: e.target.value});
    //         this.setState({firstOperandDone: true});
    //         this.setState({output: this.state.output + e.target.value});
    //     }

    //     if(e.target.value === "=") {
    //         this.setState({secondOperandDone: true});
    //         this.setState({result: this.operate(this.state.number1, this.state.number2, this.state.operation)})
    //         this.setState({output: ""});
    //         this.setState({firstOperandDone: false});
    //         this.setState({secondOperandDone: false});
    //         this.setState({number1: 0});
    //         this.setState({number2: 0});
    //         this.setState({inTheEnd: true});

    //     }
    // }

    // isOperator = (c) => {
    //     return c === "+" || c === "-" || c === "x" || c === "/";
    // }

    // operate = (a, b, op) => {
    //     console.log("hi6");
    //     console.log("OP ", op);
    //     console.log("ty: ", typeof op);
    //     switch(op) {
    //         case '+': console.log("hi7"); 
    //                     return a + b;
    //         case '-': return a - b;
    //         case 'x': return a * b;
    //         case '/': return a / b;
    //     }
    // }

   
    render() {
        return (
            <div className="flex flex-col items-center m-12">
                {this.props.inTheEnd && <p>Output: {this.props.result}</p>}
                {!this.props.inTheEnd && <p>Output: {this.props.output}</p>}
                
                <section className="m-4">
                    
                    <ButtonGroup onClick={this.props.processButtonPress} >
                            {this.props.buttons.map(function (item) {
                            return (
                                <Button className="w-72 flex-1" key={item.key} variant="primary" value={item.name}>{item.name}</Button>
                            );
                            })}
                    </ButtonGroup>
                </section>
            </div>
        );
    }
}

export default Calculator;