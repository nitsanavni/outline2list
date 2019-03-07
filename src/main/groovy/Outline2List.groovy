def out(String line) { println line?.replaceAll(/\s\s+/, " ") }

def lines = System.in.newReader()
        .readLines()

Converter.convert(lines).each { out it }
