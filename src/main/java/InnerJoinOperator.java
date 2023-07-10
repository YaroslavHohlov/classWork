import java.util.ArrayList;
import java.util.Collection;

public class InnerJoinOperator implements JoinOperator {
    @Override
    public Collection join(Collection leftCollection, Collection rightCollection) {
        ArrayList<JoinedDataRow> result = new ArrayList();
//        System.out.println(Arrays.toString(left) + "\n" + Arrays.toString(right));
        for (Object leftDataRow : leftCollection) {
            for (Object rightDataRow : rightCollection)

                if (((DataRow) leftDataRow).getKey().equals(((DataRow) rightDataRow).getKey())) {
                    result.add(new JoinedDataRow(
                            ((DataRow) leftDataRow).getKey(),
                            ((DataRow) leftDataRow).getValue(),
                            ((DataRow) rightDataRow).getValue()));

                }
        }
        return result;
    }
}
