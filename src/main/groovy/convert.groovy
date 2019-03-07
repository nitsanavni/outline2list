class Converter {
    static List<String> convert(List<String> outline) {
        def prev
        def parents = []
        def level = 0
        def output
        def prevOutput

        outline.findAll { !it.trim().empty }
                .collect {
            def selfLevel = it.indexOf(it.trim())

            def doOuput = true

            if (selfLevel > level) {
                parents << [prev, level]

                level = selfLevel

                doOuput = false
            }

            if (selfLevel < level) {
                level = selfLevel

                parents = parents.findAll({ p -> p[1] < level })
            }

            prev = it.trim()

            output = prevOutput

            prevOutput = ([parents.collect({ p -> p[0] }), it.trim()].flatten()).join(" ")

            doOuput ? output : null
        }
        .minus(null)
                .plus(prevOutput)
    }
}

