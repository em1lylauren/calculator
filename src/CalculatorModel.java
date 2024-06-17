/**
 * The model of the calculator.
 */
public class CalculatorModel {
    /**
     * The max length of the string in the result text area.
     */
    private final int maxDigits = 22;
    /**
     * Text representing the current number in the result text area.
     */
    private String currentResultField;
    /**
     * Text representing the temporary variable to hold the first operand value entered.
     */
    private String prevResultField;
    /**
     * Text representing the current operation selected.
     */
    private String operationField;
    /**
     * A boolean value marking whether currentResultField is to be replaced with or concatenated with the next digit entered.
     */
    private boolean isFirst;

    /**
     * Creates a new instance of the Calculator model.
     */
    public CalculatorModel() {
        this.currentResultField = "0";
        this.prevResultField = "";
        this.operationField = "";
        this.isFirst = true;
    }

    /**
     * Changes the number displayed in the result text field.
     * @param n the digit to replace/concatenate onto the existing number
     */
    public void changeResultField(int n) {
        //Only allow addition of more digits if it's under the max limit
        if (getCurrentResultField().length() < maxDigits) {
            //Case: digit replaces existing text OR number in result field is already 0
            if (isFirst || getCurrentResultField().equals("0")) {
                setCurrentResultField(String.valueOf(n));
                this.isFirst = false;

            } else { //Case: digit is concatenated after existing text
                setCurrentResultField(getCurrentResultField() + n);
            }
        }
    }

    /**
     * Clears the result text field.
     */
    public void clearResultField() {
        //Add in rotating clear and all clear later?
        setCurrentResultField("0");
    }

    /**
     * Adds a decimal point dot (.) to the text field. Does not add one if a dot already has been added.
     */
    public void addDecimalPoint() {
        //If we are within the allowed digit length and it doesn't already have a dot
        if (getCurrentResultField().length() < maxDigits &&! getCurrentResultField().contains(".")) {
            setCurrentResultField(getCurrentResultField() + '.');
        }
    }

    /**
     * Changes the result to a percentage of 100.
     */
    public void changeToPercent() {
        //If it equals 0, it's still 0
        if (getCurrentResultField().equals("0")) {
            setCurrentResultField("0");

        } else {
            Double newResult = Double.parseDouble(getCurrentResultField()) / 100;
            setCurrentResultField(String.valueOf(newResult));
        }

        //Mimic the behaviour of the iPhone calculator
        this.isFirst = true;
    }

    /**
     * Gets the current value of the result string.
     * @return the String representing the current number in the result text field
     */
    public String getCurrentResultField() {
        return currentResultField;
    }

    /**
     * Sets the value of currentResultField.
     * @param currentResultField the new text to set the value to
     */
    public void setCurrentResultField(String currentResultField) {
        this.currentResultField = currentResultField;
    }

    /**
     * Gets the current value of the previous (temp) result field.
     * @return the String representing the current number in the previous result variable
     */
    public String getPrevResultField() {
        return prevResultField;
    }

    /**
     * Sets the value of prevResultField.
     * @param prevResultField the new text to set the value to
     */
    public void setPrevResultField(String prevResultField) {
        this.prevResultField = prevResultField;
    }

    /**
     * Gets the current value of the operation string.
     * @return the String representing the current operation
     */
    public String getOperationField() {
        return operationField;
    }

    /**
     * Sets the value of operationField.
     * @param operationField the new text to set the value to
     */
    public void setOperationField(String operationField) {
        this.operationField = operationField;
    }
}
