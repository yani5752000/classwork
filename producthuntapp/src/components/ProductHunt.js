import React, { useState } from "react";
import Alert from "react-bootstrap/Alert";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import "bootstrap/dist/css/bootstrap.min.css";

function ProductHunt() {
    
    const [orderedByUpvotes, setOrderedByUpvotes] = useState(false);
    const [orderedByDownvotes, setOrderedByDownvotes] = useState(false);
    const [orderedByAlphabet, setOrderedByAlphabet] = useState(false);
    
   

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

    const runOrderByUpvotes = () => {
        setOrderedByDownvotes(false);
        setOrderedByAlphabet(false);
        setOrderedByUpvotes(true);
    };

    function findDownvotesMaxIndex(arr) {
        let max = 0;
        
        let maxIndex = 0;
        
        for(let i = 0; i < arr.length; i++) {
            if(arr[i].downvotes > max) {
                max = arr[i].downvotes;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    function orderByDownvotes(arr) {
        const output = [];
        while(arr.length > 0) {
            
            
            let maxIndex = findDownvotesMaxIndex(arr);
           
            output.push(arr[maxIndex]);
           
            arr.splice(maxIndex, 1);
        }
        
        return output;
    }

    const productsCopy3 = [];
    for(const x of products) {
        productsCopy3.push(x);
    }

    const productsOrderedByDownvotes = orderByDownvotes(productsCopy3);

    const runOrderByDownvotes = () => {
        setOrderedByUpvotes(false);
        setOrderedByAlphabet(false);
        setOrderedByDownvotes(true);
    };

    function findAlphabeticallyFirstIndex(arr) {
        let first = arr[0].name;
        
        let firstIndex = 0;
        
        for(let i = 0; i < arr.length; i++) {
            if(arr[i].name < first) {
                first = arr[i].name;
                firstIndex = i;
            }
        }
        return firstIndex;
    }

    function orderByAlphabet(arr) {
        const output = [];
        while(arr.length > 0) {
            
            
            let firstIndex = findAlphabeticallyFirstIndex(arr);
           
            output.push(arr[firstIndex]);
           
            arr.splice(firstIndex, 1);
        }
        
        return output;
    }

    const productsCopy4 = [];
    for(const x of products) {
        productsCopy4.push(x);
    }

    const productsOrderedByAlphabet = orderByAlphabet(productsCopy4);

    const runOrderByAlphabet = () => {
        setOrderedByUpvotes(false);
        setOrderedByDownvotes(false);
        setOrderedByAlphabet(true);
    };

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

            { orderedByDownvotes &&
            <div className="grid  md:grid-cols-2 lg:grid-cols-1 gap-4">
                {productsOrderedByDownvotes.map(function (item) {
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

            { orderedByAlphabet &&
            <div className="grid  md:grid-cols-2 lg:grid-cols-1 gap-4">
                {productsOrderedByAlphabet.map(function (item) {
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
                           
            { !orderedByUpvotes && !orderedByDownvotes && !orderedByAlphabet &&
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
            <Button onClick={runOrderByUpvotes} variant="primary">Order by Upvotes</Button>
            <Button onClick={runOrderByDownvotes} variant="primary">Order by Downvotes</Button>
            <Button onClick={runOrderByAlphabet} variant="primary">Order by Alphabet</Button>
        </div>
    );
}

export default ProductHunt;