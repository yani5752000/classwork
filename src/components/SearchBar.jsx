import React, {useState} from 'react'

function SearchBar() {
  const [search, setSearch] = useState("");
  const [results, setResults] = useState([])
  
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