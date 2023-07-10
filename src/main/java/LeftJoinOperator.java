import java.util.ArrayList;
import java.util.Collection;

public class LeftJoinOperator implements JoinOperator {
    @Override
    public Collection join(Collection leftCollection, Collection rightCollection) {
        ArrayList<JoinedDataRow> result = new ArrayList();
        boolean flag = false;
//        System.out.println(Arrays.toString(left) + "\n" + Arrays.toString(right));
        for (Object leftDataRow : leftCollection) {
            flag = false;
            for (Object rightDataRow : rightCollection) {

                if (((DataRow) leftDataRow).getKey().equals(((DataRow) rightDataRow).getKey())) {
                    result.add(new JoinedDataRow(
                            ((DataRow) leftDataRow).getKey(),
                            ((DataRow) leftDataRow).getValue(),
                            ((DataRow) rightDataRow).getValue()));
                    flag = true;
                }

            }
            if (flag == false) {
                result.add(new JoinedDataRow(
                        ((DataRow) leftDataRow).getKey(),
                        ((DataRow) leftDataRow).getValue(),
                        null));
            }
        }
        return result;
    }
}
