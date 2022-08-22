import React, { useEffect, useState } from "react";
import Alert from "react-bootstrap/Alert";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import "bootstrap/dist/css/bootstrap.min.css";

function ProductHunt() {
    const [search, setSearch] = useState("");
    const [results, setResults] = useState([]);
    const [hasSearched, setHasSearched] = useState(false);
    const [initialData, setInitialData] = useState([]);
    
    useEffect(function () {
        getSearchData();
    }, []);

    // Callback functions
    async function getSearchData() {
        const res = await fetch(
            `https://t6x247uzg3.execute-api.us-east-2.amazonaws.com/dev/`
        );
        const data = await res.json();
        setInitialData(data);
    }
    
    function filterSearchData(searchTerm) {
        setHasSearched(true);
        setSearch(searchTerm);
        let filteredResults;
        if (searchTerm === "") {
            filteredResults = [];
            setHasSearched(false);
        } else {
            filteredResults = initialData.filter((item) =>
            item.title.S.includes(searchTerm.toLowerCase())
            );
        }
        setResults(filteredResults);
    }

    return (
        <div className="flex flex-col items-center m-12">
            <form className="w-1/2 flex justify-center">
            <input
                className="w-2/5 p-2 border-2 border-gray-200  "
                type="search"
                name="search"
                id="search"
                value={search}
                onChange={(e) => filterSearchData(e.target.value)}
            />
            <button
                className="border-2 m-2 border-black bg-gray-200 p-2"
                type="submit"
            >
                Search
            </button>
            </form>
            <section className="m-4">
            { hasSearched
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
            }
            </section>
        </div>
    );
}

export default ProductHunt;