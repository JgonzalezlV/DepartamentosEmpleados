public interface OperacionesDepartamento extends Operaciones{

    void cargaAutomaticaConAgregacion();
    void cargaAutomaticaConComposicion();
    void mostrarDepartamentos();
    boolean departamentosVacios();
    boolean departamentosLleno();
    int buscarHuecosDepartamentos();
    int existeDepartamento(int num);
    int buscarDepartamento(String nombreDepartamento);

}
/*
Las variables de la interfaces son siempre public static final... y tienen que tener valor si o si.
Los métodos son siempre public.
Los métodos estáticos de la interfaces no se heredan mientras que los métodos estáticos de las clases si se heredan, solo se puede acceder a un método estático de una interfaz con una referencia a la interfaz.

*/