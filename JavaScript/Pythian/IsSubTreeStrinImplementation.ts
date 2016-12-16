/**
 * Created by Denver on 12/14/2016.
 */
interface DomNode {
    value: string;
    left?: DomNode;
    right?: DomNode;
}

function isSubtree(dom: DomNode, vdom: DomNode): boolean {
    return stringFromPreOrder(dom, "").indexOf(stringFromPreOrder(vdom, "")) > -1;
}

function stringFromPreOrder(tree: DomNode, parent: string): string {
    if (!tree) {
        return "";
    }

    return parent + ":" + tree.value + stringFromPreOrder(tree.left, tree.value) +   stringFromPreOrder(tree.right, tree.value);
}

// complex test case... W00t! It works!

const dom: DomNode = {
    value: "root",
    left: {
        value: "a",
        left: {
            value: "c",
            left: {
                value: "g"
            },
            right: {
                value: "h"
            }
        },
        right: {
            value: "d",
            left: {
                value: "i"
            }
        }
    },
    right: {
        value: "b",
        left: {
            value: "e",
            right: {
                value: "j",
                left: {
                    value: "k"
                },
                right: {
                    value: "l"
                }
            }
        },
        right: {
            value: "f"
        }
    }
};

// vdom is a subtree rooted at node a. The string produced for vdom when using a pre-order traversal will be the same
// as the string produced for vdom3.
const vdom: DomNode = {
    value: "a",
    left: {
        value: "c",
        left: {
            value: "g"
        },
        right: {
            value: "h"
        }
    },
    right: {
        value: "d",
        left: {
            value: "i"
        }
    }
};

// vdom2 is a partial subtree rooted at node A however it does not include all of the descendants of node A.
const vdom2: DomNode = {
    value: "a",
    left: {
        value: "c"
    },
    right: {
        value: "d"
    }
};

// vdom3 is not a subtree of dom however the string produced for vdom3 when using a pre-order traversal
// will be the same as the string produced for vdom.
const vdom3: DomNode = {
    value: "a",
    left: {
        value: "c",
        left: {
            value: "g",
            left: {
                value: "h",
                left: {
                    value: "d"
                },
                right: {
                    value: "i"
                }
            }
        }
    }
};

// vdom4 is not a subtree of dom.
const vdom4: DomNode = {
    value: "c",
    left: {
        value: "g",
        left: {
            value: "h"
        }
    },
    right: {
        value: "a",
        left: {
            value: "i"
        },
        right: {
            value: "d"
        }
    }
};

function validSubTreeTest(): boolean {
    // vdom provided is in dom. This test should return true.
    return isSubtree(dom, vdom);
}

function invalidSubTreeTest4(): boolean {
    // vdom provided is in dom. This test should return false.
    return isSubtree(dom, vdom2);
}

function validSubTreeTest2(): boolean {
    // vdom provided is null.
    return isSubtree(dom, null);
}

function invalidSubTreeTest(): boolean {
    // vdom provided is not in dom. This test should return false.
    return isSubtree(dom, vdom3);
}

function invalidSubTreeTest2(): boolean {
    // vdom provided is not in dom. This test should return false.
    return isSubtree(dom, vdom4);
}

function invalidSubTreeTest3(): boolean {
    // dom provided is null.
    return isSubtree(null, vdom);
}

console.log("Valid sub-tree test 1.");
console.log(validSubTreeTest());
console.log("Valid sub-tree test 2.");
console.log(validSubTreeTest2());
console.log("Invalid sub-tree test 1.");
console.log(invalidSubTreeTest());
console.log("Invalid sub-tree test 2.");
console.log(invalidSubTreeTest2());
console.log("Invalid sub-tree test 3.");
console.log(invalidSubTreeTest3());
console.log("Invalid sub-tree test 4.");
console.log(invalidSubTreeTest4());


