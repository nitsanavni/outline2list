class ConverterTest extends GroovyTestCase {
    void "test convert"() {
        assert Converter.convert(["a"]) == ["a"]
        assert Converter.convert(["a", "b"]) == ["a", "b"]
        assert Converter.convert(["a", " b"]) == ["a b"]
        assert Converter.convert(["a", " b", " c"]) == ["a b", "a c"]
        assert Converter.convert(["a", " b", "c"]) == ["a b", "c"]
        assert Converter.convert(["a", " b", "  c", "d"]) == ["a b c", "d"]
    }
}
