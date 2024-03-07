/**
 * tags: data structures, implementation, linkedlist, queue
 * statement: https://codeforces.com/problemset/problem/1907/B
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

class LinkedList {
    constructor() {
        this.head = null
    }

    push(e) {
        let node = new Node(e);
        if (this.head) node.next = this.head;
        this.head = node;
    }

    isEmpty() {
        return this.head === null;
    }

    pop() {
        if (!this.head) throw new Error("List is empty");
        let data = this.head.data;
        this.head = this.head.next;
        return data;
    }
}


function main() {
    let t = +(readline());
    while (t--) {
        let chars = readline().split("");
        let uppers = new LinkedList();
        let lowers = new LinkedList();
        for (let i=0; i<chars.length; i++) {
            if (chars[i] === 'b') {
                if (!lowers.isEmpty()) chars[lowers.pop()] = null;
                chars[i] = null;
            }
            else if (chars[i] === 'B') {
                if (!uppers.isEmpty()) chars[uppers.pop()] = null;
                chars[i] = null;
            }
            else if (chars[i] >= 'a' && chars[i] <= 'z') lowers.push(i);
            else uppers.push(i);
        }
        console.log(chars.filter(c => c !== null).join(""));
    }
}
