import React, {useState, useEffect} from 'react'

function SearchBar() {
  const [hasSearched, serHasSearched] = useState(false)
  const [search, setSearch] = useState("");
  const [results, setResults] = useState([])
  const [initialData, setInitialData] = useState([])

  useEffect(() => {
    getSearchData()
  },[])
  async function getSearchData(){
    const response = await fetch('https://t6x247uzg3.execute-api.us-east-2.amazonaws.com/dev')
    const data = await response.JSON()
    setInitialData(data)
  }

  function filterSearchData(searchTerm) {
    setHasSearched(true)
    setSearch(searchTerm);
    let filteredResults;
    if (searchTerm === "") {
        filteredResults = [];
        setHasSearched(false)
    } else {
        filteredResults = initialData.filter((item) =>
        item.title.S.includes(searchTerm.toLowerCase())
        );
    }
    setResults(filteredResults);
  }

  
  return (
    <div className="flex flex-col items-center m-12">
      <div className="md:w-1/2 flex justify-center">
        <input
          className="w-full p-2 border-2 border-gray-200  "
          type="search"
          name="search"
          id="search"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
        <button
          className="border-2 m-2 border-black bg-gray-200 p-2"
          type="submit"
        >
          Search
        </button>
      </div>

    </div>
  );
}

export default SearchBar