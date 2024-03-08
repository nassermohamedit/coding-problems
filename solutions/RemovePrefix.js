/**
 * tags: ds, impl
 * statement: https://codeforces.com/problemset/problem/1714/B
 */


process.stdin.resume();
process.stdin.setEncoding("utf-8");
 
let inputString = "";
let currentLine = 0;
 
process.stdin.on("data", (inputStdin) => {
    inputString += inputStdin;
});
 
process.stdin.on("end", (_) => {
    inputString = inputString
        .trim()
        .split("\n")
        .map((string) => {
            return string.trim();
        });
 
    main();
});
 
function readline() {
    return inputString[currentLine++];
}

function solveCase(n, arr) {
    let j = n-1;
    let exist = new Set();
    while (j >= 0) {
        if (exist.has(arr[j])) break;
        exist.add(arr[j]);
        j--;
    }
    console.log(j + 1);
} 

function main() {
    let t = +(readline());
    while (t--) {
        let n = +(readline());
        let arr = readline().split(" ").map(e => parseInt(e));
        solveCase(n, arr);
    }
}
