import java.util.List;

public class Filter {

    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result;
        result = source.stream()
                .filter(x -> {
                    boolean filter = x >= treshold;
                    logger.log(filter ? "Элемент " + x + " проходит фильтрацию" : "Элемент " + x + " фильтрацию не проходит");
                    return filter;
                })
                .toList();
        logger.log("Прошли фильтрацию " + result.size() + " элементов из " + source.size());
        return result;
    }
}