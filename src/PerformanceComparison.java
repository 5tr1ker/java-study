import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerformanceComparison {

    public void runPrimitiveDataType(int size) {
        int[] l = createIntArr(size);

        long startTime = System.nanoTime();
        for (int i = 0; i < l.length; i++) {
            if (l[i] >= 0) {

            }
        }
        long endTime = System.nanoTime();

        System.out.println(String.format("for-loop: %dms", (endTime - startTime) / 1000));

        startTime = System.nanoTime();
        Arrays.stream(l).map(a -> a--).boxed().collect(Collectors.toList());
        endTime = System.nanoTime();

        System.out.println(String.format("Stream: %dms", (endTime - startTime) / 1000));
    }

    public void runReferenceDataType(int size) {
        List<Integer> l = createIntList(size);

        long startTime = System.nanoTime();
        for(int i = 0; i < l.size(); i++) {
            l.set(i, l.get(i) + 1);
        }
        long endTime = System.nanoTime();

        System.out.println(String.format("for-loop: %dns", endTime - startTime));

        startTime = System.nanoTime();
        l = l.stream().map(n -> n--).collect(Collectors.toList());
        endTime = System.nanoTime();

        System.out.println(String.format("Stream: %dns", endTime - startTime));
    }

    private int[] createIntArr(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }

        return result;
    }

    private List<Integer> createIntList(int size) {
        IntStream intStream = IntStream.range(0, size);

        return intStream.boxed().collect(Collectors.toList());
    }

}
