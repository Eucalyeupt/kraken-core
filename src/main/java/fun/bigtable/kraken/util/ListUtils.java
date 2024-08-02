package fun.bigtable.kraken.util;

import fun.bigtable.kraken.exception.BusinessException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListUtils {

    /**
     * 从列表中每隔 n 个元素取一个，并根据参数决定是否包含最后一个元素。
     *
     * @param list            原始列表
     * @param step            每隔多少个元素取一个
     * @param includeLast     是否包含最后一个元素
     * @param <T>             列表元素类型
     * @return                处理后的列表
     */
    public static <T> List<T> takeEveryNthElement(List<T> list, int step, boolean includeLast) {

        if(CollectionUtils.isEmpty(list)){
            return list;
        }

        if (step <= 0) {
            throw BusinessException.error("步长不可小于1");
        }

        List<T> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i += step) {
            resultList.add(list.get(i));
        }

        if (!includeLast) {
            int lastIndex = resultList.size() - 1;
            T lastElement = list.get(list.size() - 1);
            if (resultList.get(lastIndex).equals(lastElement)) {
                resultList.remove(lastIndex);
            }
        }

        return resultList;
    }

    /**
     * 从列表中均匀地选取 n 个元素。【但是顺序可能会乱】
     *
     * @param list            原始列表
     * @param numberOfElements 选取的元素数量
     * @param <T>             列表元素类型
     * @return                新的列表，包含均匀选取的元素
     */
    public static <T> List<T> selectEvenlySpacedElements(List<T> list, int numberOfElements) {
        if (list == null || list.isEmpty() || numberOfElements <= 0) {
            throw new IllegalArgumentException("List must not be null or empty and number of elements must be greater than 0.");
        }

        int listSize = list.size();
        if (numberOfElements > listSize) {
            throw new IllegalArgumentException("Number of elements cannot be greater than the size of the list.");
        }

        List<T> result = new ArrayList<>(numberOfElements);
        Random random = new Random();
        int start = random.nextInt(listSize - numberOfElements + 1);
        int step = (int) Math.ceil((double) listSize / numberOfElements);

        for (int i = start; i < listSize && result.size() < numberOfElements; i += step) {
            result.add(list.get(i));
        }

        // Ensure the list contains exactly numberOfElements elements
        while (result.size() < numberOfElements) {
            int index = random.nextInt(listSize);
            if (!result.contains(list.get(index))) {
                result.add(list.get(index));
            }
        }

        return result;
    }

    private ListUtils() {
    }
}
