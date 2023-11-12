package desarrollo.sprint5.apiresttest.Enumeration;

public enum Role {
    CLIENTE(1), CAJERO(2), COCINERO(3), DELIVERY(4), ADMIN(5);

    private final int valorNumerico;

    Role(int valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }

    public static Role fromValorNumerico(int valor) {
        for (Role estado : values()) {
            if (estado.valorNumerico == valor) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Valor numérico no válido: " + valor);
    }


}
