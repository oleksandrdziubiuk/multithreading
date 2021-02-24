import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {
    public static List<Integer> generate() {
        return Stream.iterate(1, n -> n)
                .limit(1_000_000)
                .collect(Collectors.toList());
    }
}
