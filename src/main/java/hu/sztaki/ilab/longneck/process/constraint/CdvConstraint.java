package hu.sztaki.ilab.longneck.process.constraint;

import hu.sztaki.ilab.longneck.Record;
import hu.sztaki.ilab.longneck.process.VariableSpace;
import hu.sztaki.ilab.longneck.process.block.BlockUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Geszler Döme <gdome@ilab.sztaki.hu>
 */
public class CdvConstraint extends AbstractAtomicConstraint {

    private int mod;
    private List<Integer> coefficients;
    private CdvLogic cdvLogic = new CdvLogic();

    @Override
    public CheckResult check(Record record, VariableSpace scope) {
        // Prepare result variable
        List<CheckResult> results = new ArrayList<>(applyTo.size());
        String details = "";

        for (String fieldName : applyTo) {
            String value = BlockUtils.getValue(fieldName, record, scope);
            if (cdvLogic.check(value)) {
                results.add(new CheckResult(this, true, fieldName, value, details));
            } else {
                results.add(new CheckResult(this, false, fieldName, value, details));
                return new CheckResult(this, false, null, null, null, results);
            }
        }
        return new CheckResult(this, true, null, null, null, results);
    }

    @Override
    public CdvConstraint clone() {
        return (CdvConstraint) super.clone();
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
        cdvLogic.setMod(mod);
    }

    public List<Integer> getCoefficients() {
        return coefficients;
    }

    public void setCoeffs(String str) {
        String[] array = str.split(" ");
        coefficients= new ArrayList<>();
        for (String element : array) {
            coefficients.add(Integer.parseInt(element));
        }
        cdvLogic.setCoeffs(coefficients);    
    }

    public void setCoefficients(List<Integer> coefficients) {
        this.coefficients = coefficients;
        cdvLogic.setCoeffs(coefficients);
    }

}
