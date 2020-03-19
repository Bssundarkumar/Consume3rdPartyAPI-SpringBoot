package com.vehicalidentificationnumber.decoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
    @JsonProperty(value = "Value")
    private String value;
    @JsonProperty(value = "ValueId")
    private String valueId;
    @JsonProperty(value = "Variable")
    private String variable;
    @JsonProperty(value = "VariableId")
    private int variableId;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }

    @Override
    public String toString() {
        return "Result{" +
                "value='" + value + '\'' +
                ", valueId='" + valueId + '\'' +
                ", variable='" + variable + '\'' +
                ", variableId='" + variableId + '\'' +
                '}';
    }
}
