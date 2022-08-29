import React, { Component } from 'react';
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
            <div><p>hiiii</p>
                
                {/* <div className="grid  md:grid-cols-2 lg:grid-cols-1 gap-4"  >
                    {this.state.products.map(function (item) {
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
                        
                       
                    
                    );
                    })}
                </div> */}
                {!this.state.orderedByUpvotes && 
                    <div className="grid  md:grid-cols-2 lg:grid-cols-1 gap-4"  >
                        {this.reorder().map(function (item) {
                        return (
                            <div class="card" key={item.key}>
                                <div class="card-body">
                                    <p class="capitalize">{item.name}</p>
                                    <p>Upvotes: {item.upvotes}-Downvotes: {item.downvotes}</p>
                                </div>
                            </div>
                        );
                        })}
                    </div>
                }
                {this.state.orderedByUpvotes && 
                    <div className="grid  md:grid-cols-2 lg:grid-cols-1 gap-4"  >
                        {this.orderByUpvotes().map(function (item) {
                        return (
                            <div class="card" key={item.key}>
                                <div class="card-body">
                                    <p class="capitalize">{item.name}</p>
                                    <p>Upvotes: {item.upvotes}-Downvotes: {item.downvotes}</p>
                                </div>
                            </div>
                        );
                        })}
                    </div>
                }
                <button onClick={() => this.props.runOrderedByUpVotes()}>Order By Upvotes</button>

                
            </div>
        );
    }
}

export default ProductHunt;