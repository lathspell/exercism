class Deque<T> {

    private data class Node<T>(var left: Node<T>?, var right: Node<T>?, var data: T?) {
        fun lastElement(): Node<T> {
            var node = this
            while (node.right != null) node = node.right!!
            return node
        }
    }

    private var root: Node<T>? = null

    fun pop(): T {
        val lastElement = root!!.lastElement()
        if (lastElement.left != null) {
            lastElement.left!!.right = null
        }
        return lastElement.data!!
    }

    fun push(n: T) {
        if (root == null) {
            root = Node<T>(null, null, n)
        } else {
            val oldLast = root!!.lastElement()
            oldLast.right = Node<T>(oldLast, null, n)
        }
    }

    fun shift(): T {
        val first = root!!
        if (first.right != null) {
            root = first.right!!
            root!!.left = null
        }
        return first.data!!
    }

    fun unshift(n: T) {
        if (root == null) {
            root = Node(null, null, n)
        } else {
            val first = root!!
            root = Node(null, first, n)
            first.left = root
        }
    }
}