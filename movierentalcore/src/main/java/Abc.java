import pl.KarolGrabowski.CsvObject;

public class Abc implements CsvObject {
    @Override
    public String toCSVString() {
        return  "ABC";
    }
}
