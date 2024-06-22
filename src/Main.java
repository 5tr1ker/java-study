public class Main {
    public static void main(String[] args) {

        PerformanceComparison performanceComparison = new PerformanceComparison();

        System.out.println("____원시 데이터____");
        performanceComparison.runPrimitiveDataType(1_000_000);
        System.out.println("____참조 데이터____");
        performanceComparison.runReferenceDataType(100);
    }
}