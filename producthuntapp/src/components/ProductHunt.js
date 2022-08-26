import React, { useState } from "react";
import Alert from "react-bootstrap/Alert";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import "bootstrap/dist/css/bootstrap.min.css";

function ProductHunt() {
    const [search, setSearch] = useState("");
    const [results, setResults] = useState([]);
    const [hasSearched, setHasSearched] = useState(false);
    const [initialData, setInitialData] = useState([]);
    const [orderedByUpvotes, setOrderedByUpvotes] = useState(false);
    
   

    // Callback functions
    
    const products = [
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
        },
    ];

    function getRandomInt(max) {
        return Math.floor(Math.random() * max);
      }

    function reorder(array) {
        const output = [];
        while(array.length > 0) {
            let index = getRandomInt(array.length);
            output.push(array[index]);
            array.splice(index, 1);
        }
        console.log("hi22222", output);
        return output;
    }
    const productsCopy = [];
    for(const x of products) {
        productsCopy.push(x);
    }
    const products1 = reorder(productsCopy);

    function findMaxIndex(arr) {
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
    
    function orderByUpvotes(arr) {
        const output = [];
        while(arr.length > 0) {
            
            
            let maxIndex = findMaxIndex(arr);
            console.log("findMax!!! ", maxIndex);
            output.push(arr[maxIndex]);
            console.log("OOOO ", output);
            arr.splice(maxIndex, 1);
        }
        console.log("hi******", output);
        return output;
    }
    
    const productsCopy2 = [];
    for(const x of products) {
        productsCopy2.push(x);
    }

    const productsOrderedByUpvotes = orderByUpvotes(productsCopy2);

    return (
        <div className="flex flex-col items-center m-12">
           
            <section className="m-4">
            {/* { hasSearched
            ?
            <div>
                <Alert variant="danger"  className={results.length > 0 ? "hidden" : "block"}>There is nothing with the title <span className="font-bold ">{search}</span></Alert>
                <div className = "grid  md:grid-cols-2 lg:grid-cols-3 gap-4" >
                {results.map(function (item) {
                    return (
                    <Card  className="w-72 flex-1"  key={item.title.S}>
                    <Card.Body >
                        <Card.Title className="capitalize">{item.title.S}</Card.Title>
                        <Card.Text>{item.description.S}</Card.Text>
                        <Button variant="primary">More Details</Button>
                    </Card.Body>
                    </Card>
                    );
                })}
                </div>
            </div>
            :
            <div className="grid  md:grid-cols-2 lg:grid-cols-3 gap-4"  >
                {initialData.map(function (item) {
                return (
                    <Card className="w-72 flex-1"  key={item.title.S}>
                    <Card.Body >
                        <Card.Title className="capitalize">{item.title.S}</Card.Title>
                        <Card.Text>{item.description.S}</Card.Text>
                        <Button variant="primary">More Details</Button>
                    </Card.Body>
                    </Card >
                );
                })}
            </div>
            } */}

           { orderedByUpvotes &&
            <div className="grid  md:grid-cols-2 lg:grid-cols-1 gap-4">
                {productsOrderedByUpvotes.map(function (item) {
                return (
                    <Card className="w-72 flex-1"  key={item.key}>
                    <Card.Body >
                        <Card.Title className="capitalize">{item.name}</Card.Title>
                        <Card.Text>Upvotes: {item.upvotes}-Downvotes: {item.downvotes}</Card.Text>
                        <Button variant="primary">More Details</Button>
                    </Card.Body>
                    </Card >
                );
                })}
            </div>}
                           
            { !orderedByUpvotes &&
                <div className="grid  md:grid-cols-2 lg:grid-cols-1 gap-4"  >
                {products1.map(function (item) {
                return (
                    <Card className="w-72 flex-1"  key={item.key}>
                    <Card.Body >
                        <Card.Title className="capitalize">{item.name}</Card.Title>
                        <Card.Text>Upvotes: {item.upvotes}-Downvotes: {item.downvotes}</Card.Text>
                        <Button variant="primary">More Details</Button>
                    </Card.Body>
                    </Card >
                );
                })}
            </div> }
            </section>
            <Button onClick={() => setOrderedByUpvotes(true)} variant="primary">Order by Upvotes</Button>
        </div>
    );
}

export default ProductHunt;