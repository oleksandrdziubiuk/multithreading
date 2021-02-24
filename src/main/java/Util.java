import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {
    private static final int LIMIT = 1_000_000;

    public static List<Integer> generate() {
        return Stream.iterate(1, n -> n)
                .limit(LIMIT)
                .collect(Collectors.toList());
    }
}
