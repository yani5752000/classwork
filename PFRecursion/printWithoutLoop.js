let dir = "down";
function prt(n, x, d) {
    if(n > x) {
        return;
    }
    if( n > 0) {
        console.log(n);
        prt(n - d, x, d);
    }
    
    if(n <= 0) {
        console.log(n);
        d = -d;
        prt(n - d, x, d);
    }
}

prt(16, 16, 3);