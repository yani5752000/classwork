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

console.log("products: ", products);



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
        output.push(arr[maxIndex]);
        arr.splice(maxIndex, 1);
    }
    
    return output;
}

const productsOrderedByUpvotes = orderByUpvotes(products);

console.log("productsOrderedByUpvotes: ", productsOrderedByUpvotes);