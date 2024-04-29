package br.com.luds.Luds.commons.model;

public enum SimNaoEnum {
    SIM("S"),
    NAO("N");

    private String cod;

    private SimNaoEnum(String cod) {
        this.cod = cod;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }


    public static SimNaoEnum toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (SimNaoEnum x : SimNaoEnum.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Codigo invalido: " + cod);
    }
}
