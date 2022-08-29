import React, { Component } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

class ProductHunt extends Component {
    constructor(props) {
        super(props);
        this.state = {
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
            </div>
        );
    }
}

export default ProductHunt;