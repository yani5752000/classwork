import React, { useEffect} from "react";

function WithCleanupExample() {

    useEffect(() => {
    // EFFECT LOGIC
    var timeout

    document.onmousemove = function () {
        clearTimeout(timeout);
        timeout = setTimeout(() => {
        alert("You will be logged out if you are not active in the next 30 seconds");
        }, 5000);
    };

    //EFFECT CLEAN UP
    return function cleanUp() {
        console.log("Cleaned up")
        clearTimeout(timeout);
        document.onmousemove = null;
    };
    });

    return (
    <>
        <h1>Component With Effect</h1>
    </>
    );
}

export default WithCleanupExample;