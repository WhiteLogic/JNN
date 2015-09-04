package org.nd4j.linalg.indexing.conditions;

import org.nd4j.linalg.api.complex.IComplexNumber;

/**
 * An or between 2 conditions.
 *
 * @author Adam Gibson
 */
public class Or implements Condition {

    private Condition[] conditions;

    public Or(Condition... conditions) {
        this.conditions = conditions;
    }

    @Override
    public Boolean apply(Number input) {
        boolean ret = conditions[0].apply(input);
        for(int i = 1; i < conditions.length; i++) {
            ret = ret || conditions[i].apply(input);
        }
        return ret;
    }

    @Override
    public Boolean apply(IComplexNumber input) {
        boolean ret = conditions[0].apply(input);
        //short circuit: no need to check anything else
        if(!ret)
            return false;
        for(int i = 1; i < conditions.length; i++) {
            ret = ret || conditions[i].apply(input);
        }
        return ret;
    }
}
