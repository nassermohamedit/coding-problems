/**
 * ds, greedy
 * statement: https://codeforces.com/problemset/problem/1689/B
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

function solveCase(n, p) {
    let mystic = new Array(n);
    for (let i=0; i<n; i++) {
        mystic[i] = i + 1;
    }
    for (let i=0; i<n-1; i++) {
        if (p[i] === mystic[i]) {
            [mystic[i], mystic[i + 1]] = [mystic[i + 1], mystic[i]];
        }
    }
    if (p[n - 1] === mystic[n - 1]) {
        [mystic[n-1], mystic[n-2]] = [mystic[n-2], mystic[n-1]];
    }
    console.log(mystic.join(" "));
}

function main() {
    let t = +(readline());
    while (t--) {
        let n = +(readline());
        let p = readline().split(" ").map(e => parseInt(e));
        if (n === 1) console.log(-1);
        else solveCase(n, p);
    }
}
