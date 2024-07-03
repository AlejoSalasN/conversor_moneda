public record MonedasOmdb(
        String origen,
        String destino,
        String conversion,
        String fecha
) {
    public MonedasOmdb(String origen, String destino, String conversion, String fecha) {
        this.origen = origen;
        this.destino = destino;
        this.conversion = conversion;
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "Conversion{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", conversion='" + conversion + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
