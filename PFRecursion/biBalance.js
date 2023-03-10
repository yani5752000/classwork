function balance(x) {
   if(x.length == 2) {
    return x[0] - x[1];
   }
   x1 = [];
   for(i = 1; i < x.length - 1; i++) {
    x1.push(x[i]);
   }
    return x[0] - x[x.length - 1] + balance(x1);
}

console.log(balance([1, 0, 0, 1, 1, 0]));