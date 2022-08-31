import React, { Component } from 'react';
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import "bootstrap/dist/css/bootstrap.min.css";

class ProductHunt extends Component {
    constructor(props) {
        super(props);
        // this.state = {
        //     products: [
        //         {
        //             key: 1,
        //             name: "turnip",
        //             upvotes: 5,
        //             downvotes: 6
        //         },
        //         {
        //             key: 2,
        //             name: "garlic",
        //             upvotes: 11,
        //             downvotes: 3
        //         },
        //         {
        //             key: 3,
        //             name: "onion",
        //             upvotes: 8,
        //             downvotes: 9
        //         }
        //     ],
        //     orderedByUpvotes: false
        // };   

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
            <div className="flex flex-col items-center m-12"><p>hiiii</p>
                <section className="m-4">
                {!this.props.orderedByUpvotes && 
                         <div className="grid  md:grid-cols-2 lg:grid-cols-3 gap-4"  >
                            {this.reorder().map(function (item) {
                            return (
                                <Card style={{width:"20%"}} className="w-72 flex-1"  key={item.key}>
                                <Card.Body >
                                    <Card.Title className="capitalize">{item.name}</Card.Title>
                                    <Card.Text>Upvotes: {item.upvotes}-Downvotes: {item.downvotes}</Card.Text>
                                    <Button variant="primary">More Details</Button>
                                </Card.Body>
                                </Card >
                            );
                            })}
                        </div>
                        }
                        {this.props.orderedByUpvotes &&
                            <div className="grid  md:grid-cols-2 lg:grid-cols-3 gap-4"  >
                                {this.props.orderByUpvotes().map(function (item) {
                                return (
                                    <Card  style={{width:"20%"}}  className="w-72 flex-1"  key={item.key}>
                                    <Card.Body >
                                        <Card.Title className="capitalize">{item.name}</Card.Title>
                                        <Card.Text>Upvotes: {item.upvotes}-Downvotes: {item.downvotes}</Card.Text>
                                        <Button variant="primary">More Details</Button>
                                    </Card.Body>
                                    </Card >
                                );
                                })}
                            </div>
                            // <div className="grid  md:grid-cols-2 lg:grid-cols-1 gap-4"  >
                            //     {this.props.orderByUpvotes().map(function (item) {
                            //     return (
                            //         <div class="card" key={item.key}>
                            //             <div class="card-body">
                            //                 <p class="capitalize">{item.name}</p>
                            //                 <p>Upvotes: {item.upvotes}-Downvotes: {item.downvotes}</p>
                            //             </div>
                            //         </div>
                            //     );
                            //     })}
                            // </div>
                        }
                </section>
                    
                    
                    
                {/* <button onClick={() => this.props.runOrderedByUpVotes()}>Order By Upvotes</button> */}
                <Button onClick={() => this.props.runOrderedByUpVotes()} variant="primary">Order By Upvotes</Button>

                
            </div>
        );
    }
}

export default ProductHunt;