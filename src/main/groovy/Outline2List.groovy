def prev
def parents = []
def level = 0
def output
def prevOutput

System.in.newReader()
        .readLines()
        .findAll { !it.trim().empty }
        .collect {
    def selfLevel = it.indexOf(it.trim())

    def doOuput = true

    if (selfLevel > level) {
        level = selfLevel

        parents << prev

        doOuput = false
    }

    if (selfLevel < level) {
        level = selfLevel

        parents.pop()
    }

    prev = it

    output = prevOutput

    prevOutput = parents.join() + it

    doOuput ? output : null
}
.minus(null)
        .each { out it }

out prevOutput

def out(String line) { println line.replaceAll(/\s\s+/, " ") }