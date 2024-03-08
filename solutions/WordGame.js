/**
 * tags: ds, implementation
 * statement: https://codeforces.com/problemset/problem/1722/C
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

function solveCase(n, a1, a2, a3) {
    let ws = new Map();
    for (let i=0; i<n; i++) {
        if (ws.has(a1[i])) ws.set(a1[i], ws.get(a1[i]) | 1)
        else ws.set(a1[i], 1);
        
        if (ws.has(a2[i])) ws.set(a2[i], ws.get(a2[i]) | 2)
        else ws.set(a2[i], 2);
       
        if (ws.has(a3[i])) ws.set(a3[i], ws.get(a3[i]) | 4)
        else ws.set(a3[i], 4);
    }
    let [c1, c2, c3] = [0, 0, 0];
    ws.forEach((v, k) => {
        let a = (v & 1)  === 1;
        let b = (v & 2) === 2;
        let c = (v & 4) === 4;
        let ps = 3 - (a + b + c);
        ps = (ps === 2)? 3: ps;
        if (a) c1 += ps;
        if (b) c2 += ps;
        if (c) c3 += ps;
    })
    console.log(`${c1} ${c2} ${c3}`);
}

function main() {
    let t = +(readline());
    while (t--) {
        let n = +(readline());
        let arr1 = readline().split(" ");
        let arr2 = readline().split(" ");
        let arr3 = readline().split(" ");
        solveCase(n, arr1, arr2, arr3);
    }
}
