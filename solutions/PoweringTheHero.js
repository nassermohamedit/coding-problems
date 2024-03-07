/**
 * tags: ds, priority queue
 * statement: https://codeforces.com/problemset/problem/1800/C1
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

class Node {
    
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class PriorityQueue {
    
    constructor() {
        this.head = null;
    }

    pop() {
        if (this.head === null) throw new Error("Queue is Empty");
        let data = this.head.data;
        this.head = this.head.next;
        return data;
    }

    push(data) {
        let node = new Node(data);
        if (this.head === null) {
            this.head = node;
            return;
        }
        if (data >= this.head.data) {
            node.next = this.head;
            this.head = node;
            return;
        }
        let x = this.head
        while (x.next !== null && data < x.next.data)
            x = x.next;
        if (x.next !== null)
            node.next = x.next;
        x.next = node;
    }

    isEmpty() {
        return this.head === null;
    }

}

let arr = new Array(5005).fill(0);

function main() {

    let t = +(readline());
    while (t--) {
        let n = +(readline());
        +(readline()).split(' ').forEach((e, i) => { arr[i] = parseInt(e); });
        console.log(solveCase(n));
    }
}

function solveCase(n) {

    let queue = new PriorityQueue();
    let answer = 0;
    for (let i=0; i<n; i++) {
        if (arr[i] > 0) queue.push(arr[i]);
        else if (!queue.isEmpty()) answer += queue.pop();
    }
    return answer;
}

