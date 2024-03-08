/**
 * tags: data structures, implementation, easy
 * statement: https://codeforces.com/problemset/problem/1730/A
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

function solveCase(n, c, arr) {
    let answer = 0;
    let ppo = new Map();
    for (let i=0; i<n; i++) {
        let k = arr[i];
        if (ppo.has(k)) ppo.set(k, ppo.get(k) + 1);
        else ppo.set(k, 1);
    }
    ppo.forEach((v, k) => {
        answer += (v < c)? v: c;
    })
    console.log(answer);
}

function main() {
    let t = +(readline());
    while (t--) {
        let [n, c] = readline().split(" ").map(e => parseInt(e));
        let arr = readline().split(" ").map(e => parseInt(e));
        solveCase(n, c, arr);
    }
}
