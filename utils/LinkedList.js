

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
