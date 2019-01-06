package main

fun <T> Sequence<T>.takeFor(predicate: (T) -> Boolean): Sequence<T> {
    return TakeForSequence(this, predicate)
}

internal class TakeForSequence<T>
constructor(
    private val sequence: Sequence<T>,
    private val predicate: (T) -> Boolean
) : Sequence<T> {
    override fun iterator(): Iterator<T> = object : Iterator<T> {
        val iterator = sequence.iterator()
        var nextState: Int = -1 // -1 for unknown, 0 for done, 1 for continue
        var nextItem: T? = null
        var doneFlag = false

        private fun calcNext() {
            if (iterator.hasNext()) {
                val item = iterator.next()
                if (predicate(item) && !doneFlag) {
                    nextState = 1
                    nextItem = item
                    return
                } else if(!doneFlag){ // add stop
                    doneFlag = true
                    nextState = 1
                    nextItem = item
                    return
                }
            }
            nextState = 0
        }

        override fun next(): T {
            if (nextState == -1)
                calcNext() // will change nextState
            if (nextState == 0)
                throw NoSuchElementException()
            @Suppress("UNCHECKED_CAST")
            val result = nextItem as T

            // Clean next to avoid keeping reference on yielded instance
            nextItem = null
            nextState = -1
            return result
        }

        override fun hasNext(): Boolean {
            if (nextState == -1)
                calcNext() // will change nextState
            return nextState == 1
        }
    }
}
