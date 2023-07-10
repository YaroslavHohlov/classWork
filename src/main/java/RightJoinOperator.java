import java.util.ArrayList;
import java.util.Collection;

public class RightJoinOperator implements JoinOperator {
    @Override
    public Collection join(Collection leftCollection, Collection rightCollection) {
        ArrayList<JoinedDataRow> result = new ArrayList();
        ArrayList<DataRow> copyRight = new ArrayList();
        copyRight.addAll(rightCollection);
//        System.out.println(Arrays.toString(left) + "\n" + Arrays.toString(right));
        for (Object leftDataRow : leftCollection) {
            for (Object rightDataRow : rightCollection) {

                if (((DataRow) leftDataRow).getKey().equals(((DataRow) rightDataRow).getKey())) {
                    copyRight.remove(rightDataRow);
                    result.add(new JoinedDataRow(
                            ((DataRow) leftDataRow).getKey(),
                            ((DataRow) leftDataRow).getValue(),
                            ((DataRow) rightDataRow).getValue()));
                }

            }
        }
        for (Object notUsedObj : copyRight) {
            result.add(new JoinedDataRow(
                    ((DataRow) notUsedObj).getKey(),
                    null,
                    ((DataRow) notUsedObj).getValue()));
        }

        return result;
    }
}
