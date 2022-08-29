import React, { Component } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import ProductHunt from './ProductHunt';

class Parent extends Component {
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
            orderedByUpvotes: false
        };   

    }

    reorder = () => {
        const array = [];
        for (const item of this.state.products) {
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

    findMaxIndex = (arr) => {
        let max = 0;
        
        let maxIndex = 0;
        
        for(let i = 0; i < arr.length; i++) {
            if(arr[i].upvotes > max) {
                max = arr[i].upvotes;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    orderByUpvotes = () => {
        const arr = [];
        for (const item of this.state.products) {
            arr.push(item);
        }
        const output = [];
        while(arr.length > 0) {
            
            
            let maxIndex = this.findMaxIndex(arr);
           
            output.push(arr[maxIndex]);
            
            arr.splice(maxIndex, 1);
        }
        
        return output;
    }

    runOrderedByUpVotes = () => {
        this.setState({orderedByUpvotes: true});
    }

   
    render() {
        return (
            <ProductHunt runOrderedByUpVotes={this.runOrderedByUpVotes} 
            products={this.state.products}></ProductHunt>
        );
    }
}

export default Parent;