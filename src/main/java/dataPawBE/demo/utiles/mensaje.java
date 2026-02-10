package dataPawBE.demo.utiles;

public enum mensaje {
    
    Error_De_Nombre("Error en el nombre ingresado, revisa por favor");

    private final String texto;

    private mensaje (String texto) {
        this.texto = texto;
    }

    public String getTexto () {
        return texto;
    }
}
