/**
 * Enunciado --> Gestion de departamentos y empleados.
 * @author Josu González López
 * @version 1
 * @date 22/02/2022
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Principal implements OperacionesDepartamento,OperacionesEmpleado{
    /**
     * Atributos de la clase:
     */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean salirMenu = false;
    private static boolean salirMenuEmpleados = false;
    private static boolean salirMenuDepartamentos = false;
    private static boolean salirMenuModificaciones = false;
    static Departamento[] departamentos = new Departamento[TAM];
    private static int numeroDepartamentos;
    private static int posicionInserciones;

    public static void main(String[] args) throws IOException {

        Principal p = new Principal(); //Se crea el objeto por la interfaces, así podemos usar los métodos de las interfaces.
        p.cargaAutomaticaConComposicion();
        //cargaAutomaticaConAgregacion();
        //p.menuPrincipal();
        /*System.out.println(p.buscarDepartamento("Ventas"));
        p.buscarDepartamento();*/
        //p.modificarFechaAltaEmp(); PREGUNTAR COMO VA.
        //p.modificarDepartamentoEmpleado(); PREGUNTAR COMO VA.
        p.mostrarEmpleados(departamentos[0]);
    }
    /**
     * Cargas automáticas de departamentos y empleados:
     * cargaAutomaticaConAgregacion()
     * cargaAutomaticaConComposicion()
     */
    //Método de carga automática mediante agregación.
    public void cargaAutomaticaConAgregacion() {

        Empleado[] empleados = new Empleado[TAM];

        empleados[0] = new Director(1,"Ana", LocalDate.of(1999,12,10), 2200,null,542.36);
        empleados[1] = new Analista(12,"Oscar",LocalDate.of(1989,02,10),2280,null);
        empleados[2] = new Director(36,"Maria",LocalDate.of(1993,01,06),2300,null,781.36);
        empleados[3] = new Analista(23,"Amancio",LocalDate.of(1978,11,23),3000,null);

        departamentos[0] = new Departamento("Finanzas", "Barcelona", 15, empleados);
        departamentos[1] = new Departamento("Inovaccion", "Helechosa de los Montes", 90, empleados);

        empleados[0].setDepartamento(departamentos[0]);
        empleados[1].setDepartamento(departamentos[0]);
        empleados[2].setDepartamento(departamentos[1]);
        empleados[3].setDepartamento(departamentos[1]);

        numeroDepartamentos = 2;
        posicionInserciones = 2;

    }
    //Método de carga automática mediante composición.
    public void cargaAutomaticaConComposicion() {

        departamentos[0] = new Departamento("Ventas", "Barcelona", 15);
        departamentos[1] = new Departamento("Inovaccion", "Helechosa de los Montes", 90);

        numeroDepartamentos = 2;
        posicionInserciones = 2;

    }
    /**
     * Métodos que pintan un menú:
     * menuPrincipal()
     * menuDepartamentos()
     * menuEmpleados()
     * modificarDepartamentos()
     */
    //Método que pinta el menú principal.
    public void menuPrincipal() throws IOException {

        int eleccionMenu = 0;

        do {
            System.out.println("Menu principal ");
            System.out.println("Con que deseas trabajar: ");
            System.out.println("1. Departamentos. ");
            System.out.println("2. Empleados. ");
            System.out.println("3. Salir. ");
            try {
                eleccionMenu = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se admiten NÚMEROS. ");
                menuPrincipal();
            }
            switch (eleccionMenu) {
                case 1:
                    menuDepartamentos();
                    break;
                case 2:
                    menuEmpleados();
                    break;
                case 3:
                    System.out.println("Fin programa. ");
                    salirMenu = true;
                    break;
            }
        } while (!salirMenu);
    }
    //Método que pinta el menú de gestión de departamentos.
    public void menuDepartamentos() throws IOException {

        int eleccionMenuDepartamento = 0;

        do {
            System.out.println("¿Qué deseas hacer? ");
            System.out.println("1. Mostrar departamentos. ");
            System.out.println("2. Modificar los departamentos. ");
            System.out.println("3. Borrar los departamentos. ");
            System.out.println("4. Insertar departamentos. ");
            System.out.println("5. Volver al menú principal. ");
            try {
                eleccionMenuDepartamento = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se admiten NÚMEROS. ");
                menuPrincipal();
            }
            switch (eleccionMenuDepartamento) {
                case 1:
                    mostrarDepartamentos();
                    break;
                case 2:
                    mostrarDepartamentos();
                    modificarDepartamento();
                    break;
                case 3:
                    mostrarDepartamentos();
                    borrarDepartamentos();
                    break;
                case 4:
                    mostrarDepartamentos();
                    insertarDepartamentos();
                    break;
                case 5:
                    menuPrincipal();
                    salirMenuDepartamentos = true;
                    break;
            }
        } while (!salirMenuDepartamentos);

    }
    //Método que pinta el menú de gestión de empleados.
    public void menuEmpleados() throws IOException {

        int eleccionMenuEmpleado = 0;
        int departamento; //Esta variable sirve para que el usuario escoja entre los departamentos que hay.

        do {
            System.out.println("¿Qué deseas hacer? ");
            System.out.println("1. Mostrar empleados. ");
            System.out.println("2. Modificar a los empleados. ");
            System.out.println("3. Borrar los empleados. ");
            System.out.println("4. Insertar empleados. ");
            System.out.println("5. Volver al menú principal. ");
            try {
                eleccionMenuEmpleado = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se admiten NÚMEROS. ");
                menuPrincipal();
            }
            switch (eleccionMenuEmpleado) {
                case 1:
                    System.out.println("De que departamento quieres mostrar los empleados: ");
                    departamento = Integer.parseInt(br.readLine());
                    mostrarEmpleados(departamentos[departamento]);
                    break;
                case 2:
                    System.out.println("De que departamento quieres mostrar los empleados: ");
                    departamento = Integer.parseInt(br.readLine());
                    mostrarEmpleados(departamentos[departamento]);
                    modificarEmpleados();
                    break;
                case 3:
                    System.out.println("De que departamento quieres mostrar los empleados: ");
                    departamento = Integer.parseInt(br.readLine());
                    mostrarEmpleados(departamentos[departamento]);
                    borrarEmpleado();
                    break;
                case 4:
                    System.out.println("De que departamento quieres mostrar los empleados: ");
                    departamento = Integer.parseInt(br.readLine());
                    mostrarEmpleados(departamentos[departamento]);
                    insertarEmpleado();
                    break;
                case 5:
                    menuPrincipal();
                    salirMenuEmpleados = true;
                    break;
            }
        } while (!salirMenuEmpleados);

    }
    //Método que pinta el menú de modicicaciones de los departamentos.
    public void modificarDepartamento() throws IOException{

        int eleccionMenuModificacionesDepartamentos = 0;

        do {
            System.out.println("Menú para modificaciones: ");
            System.out.println("1. Modificar el nombre del departamento. ");
            System.out.println("2. Modificar la localidad del departamento. ");
            System.out.println("3. Modificar el numero del departamento. ");
            System.out.println("4. Volver al menú del departamento. ");
            try {
                eleccionMenuModificacionesDepartamentos = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se admiten NÚMEROS. ");
                menuDepartamentos();
            }
            switch (eleccionMenuModificacionesDepartamentos) {
                case 1:
                    mostrarDepartamentos();
                    modificarNombreDepartamento();
                    break;
                case 2:
                    mostrarDepartamentos();
                    modificarLocalizacionDepartamento();
                    break;
                case 3:
                    mostrarDepartamentos();
                    modificarNumeroDepartamento();
                    break;
                case 4:
                    menuDepartamentos();
                    salirMenuModificaciones = true;
                    break;
            }
        } while (!salirMenuModificaciones);
    }
    //TERMINARLO
    public void modificarEmpleados() throws IOException{

        int eleccionMenuModificacionesEmpleados = 0;
        int departamento = 0;

        do {
            System.out.println("Menú para modificaciones: ");
            System.out.println("1. MOdificar el número del empleado. ");
            System.out.println(". Volver al menú del empleados. ");
            try {
                eleccionMenuModificacionesEmpleados = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Solo se admiten NÚMEROS. ");
                menuEmpleados();
            }
            System.out.println("De que departamento quieres modificar los empleados: ");
            departamento = Integer.parseInt(br.readLine());
            switch (eleccionMenuModificacionesEmpleados) {
                case 1:
                    mostrarEmpleados(departamentos[departamento]);
                    modificarNumEmpleado();
                    break;
                case 2:
                    mostrarEmpleados(departamentos[departamento]);
                    modificarNombreEmpleado();
                    break;
                case 3:
                    mostrarEmpleados(departamentos[departamento]);
                    modificarFechaAltaEmp();
                    break;
                case 4:
                    mostrarEmpleados(departamentos[departamento]);
                    modificarSalarioEmpleado();
                case 5:
                    mostrarEmpleados(departamentos[departamento]);
                    modificarDepartamentoEmpleado();
                case 6:
                    menuEmpleados();
                    salirMenuModificaciones = true;
                    break;
            }
        } while (!salirMenuModificaciones);
    }


    /**
     * Métodos para la gestión de departamentos:
     * mostrarDepartamentos()
     * insertarDepartamentoSinEmpleados(String nombre, String localizacion, int dept_no)
     * insertarDepartamentos()
     * borrarDepartamentos(int dept_no)
     * borrarDepartamentos()
     * modificarNombreDepartamento(int dept_no, String nombre)
     * modificarNombreDepartamento()
     * modificarLocalizacionDepartamento(int dept_no,String localizacion)
     * modificarLocalizacionDepartamento()
     * modificarNumeroDepartamento(int dept_no,int nuevoDept_no)
     * modificarNumeroDepartamento()
     */
    //Método que muestra los departamentos.
    public void mostrarDepartamentos() {

        System.out.println("Departamentos: ");
        if (departamentosVacios()){
            System.out.println("No hay departamentos. ");
        }
        else
        for (int i = 0; i < departamentos.length; i++) {
            if (departamentos[i] != null) {
                System.out.print("Nombre: " + departamentos[i].getNombre() + ", ");
                System.out.print("Localizacion: " + departamentos[i].getLocalizacion() + ", ");
                System.out.print("Numero de departamento: " + departamentos[i].getDept_no() + ", ");
                System.out.print("Empleados: " + departamentos[i].getEmpleados() + ". ");
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Hay un total de " + numeroDepartamentos + " de departamentos. ");
        System.out.println("La proxima posicion para insertar es " + posicionInserciones + ".");
    }
    //Método que inserta departamentos sin interactividad.
    public int insertarDepartamentoSinEmpleados(String nombre, String localizacion, int dept_no){

        int posicion = 0;

        if (departamentosLleno() == true){
            return -1; // Retorna -1 si no se ha podido insertar un nuevo departamento.
        }else{
            departamentos[posicionInserciones] = new Departamento(nombre,localizacion,dept_no);
            posicion = posicionInserciones;
            numeroDepartamentos++;
            posicionInserciones = buscarHuecosDepartamentos();
            return posicion; //Retorna la posicion en la que se ha insertado el nuevo departamento.
        }
    }
    //Método que inserta los departamentos con interactividad.
    public void insertarDepartamentos() throws IOException{

        System.out.println("Introduzca el número del departamento. ");
        int dept_no = Integer.parseInt(br.readLine());
        System.out.println("Introduzca el nombre del departamento. ");
        String nombre = br.readLine();
        System.out.println("Introduzca la población en la que se encuentra el departamento. ");
        String localizacion = br.readLine();
        if (insertarDepartamentoSinEmpleados(nombre,localizacion,dept_no) >=0 ){
            System.out.println("Se ha añadido el nuevo departamento. ");
            mostrarDepartamentos();
        }else{
            System.out.println("No se ha insertado el nuevo departamento por que está lleno. ");
        }
    }
    //Método que borra los departamentos sin interactividad.
    public int borrarDepartamentos(int dept_no) throws IOException {

        int posicion;

        if (departamentosVacios()) {
            return 0; //Devuelve -1 si no existe el departamento.
        } else {
            if (existeDepartamento(dept_no) < 0) {
                   return -1; //Devuelve -1, si no existe el departamento.
            }else{
                posicion = existeDepartamento(dept_no);
                departamentos[posicion] = null;
                posicionInserciones--;
                numeroDepartamentos--;
                return 1; //Devuelve 1 si se ha borrado correctamente.
            }
        }
    }
    //Método que borra los departamentos con interactividad.
    public void borrarDepartamentos() throws IOException {

        int numeroDepartamento = 0;

        System.out.println("Introduzca el número de departamento que deseas borrar: ");
        try {
            numeroDepartamento = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            menuDepartamentos();
        }
        if (borrarDepartamentos(numeroDepartamento) == 1) {
            borrarDepartamentos(numeroDepartamento);
            System.out.println("Se ha borrado el departamento correctamente. ");
            mostrarDepartamentos();
        } else {
            System.out.println("No se ha podido borrar por que puede que no exista ningun departamento con ese numero o no hay departamentos. ");
        }
    }
    //Método que modifica el nombre del departamento que le pase por argumento.
    public int modificarNombreDepartamento(int dept_no, String nombre){

        int posicion;
        if (existeDepartamento(dept_no) >= 0){
                posicion = existeDepartamento(dept_no);
                departamentos[posicion].setNombre(nombre);
                return 1;
        }else{
            return -1;
        }
    }
    //Método que modifica el nombre de un departamento interactivo.
    public void modificarNombreDepartamento() throws IOException{

        int dept_no = 0;

        System.out.println("Introduzca el código del departamento que quieras modificar. ");
        try {
            dept_no = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarDepartamento();
        }
        System.out.println("Introduzca el nuevo nombre del departamento. ");
        String nuevoNombre = br.readLine();
        if (modificarNombreDepartamento(dept_no,nuevoNombre) == 1){
            System.out.println("Se ha modificado correctamente. ");
            mostrarDepartamentos();
        }else{
            System.out.println("No se ha podido modificar por que puede que no exista ningun departamento con ese número. ");
        }
    }
    //Método que modifica la localización del departamento que se le pase por parámetro.
    public int modificarLocalizacionDepartamento(int dept_no,String localizacion){

        int posicion;
        if (existeDepartamento(dept_no) >= 0){
            posicion = existeDepartamento(dept_no);
            departamentos[posicion].setLocalizacion(localizacion);
            return 1;
        }else{
            return -1;
        }
    }
    //Método que modifica la localización de un departamento interactivo.
    public void modificarLocalizacionDepartamento() throws IOException{

        int dept_no = 0;

        System.out.println("Introduzca el código del departamento que quieras modificar. ");
        try {
            dept_no = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarDepartamento();
        }
        System.out.println("Introduzca la nueva localización del departamento. ");
        String nuevaLocalizacion = br.readLine();
        if (modificarLocalizacionDepartamento(dept_no,nuevaLocalizacion) == 1){
            System.out.println("Se ha modificado correctamente. ");
            mostrarDepartamentos();
        }else{
            System.out.println("No se ha podido modificar por que puede que no exista ningun departamento con ese número. ");
        }
    }
    //Método que modifica el número del departamento que se le pase por parámetro.
    public int modificarNumeroDepartamento(int dept_no,int nuevoDept_no){

        int posicion;
        if (existeDepartamento(dept_no) >= 0){
            posicion = existeDepartamento(dept_no);
            departamentos[posicion].setDept_no(nuevoDept_no);
            return 1;
        }else{
            return -1;
        }
    }
    //Método que modifica en número de un departamento interactivo.
    public void modificarNumeroDepartamento()throws IOException{

        int nuevoDept_no = 0;
        int dept_no = 0;

        System.out.println("Introduzca el código del departamento que quieras modificar. ");
        try {
            dept_no = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarDepartamento();
        }
        System.out.println("Introduzca el nuevo número del departamento. ");
        try {
            nuevoDept_no = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarDepartamento();
        }
        if (modificarNumeroDepartamento(dept_no,nuevoDept_no) == 1){
            System.out.println("Se ha modificado correctamente. ");
            mostrarDepartamentos();
        }else{
            System.out.println("No se ha podido modificar por que puede que no exista ningun departamento con ese número. ");
        }
    }
    /**
     * Métodos para la gestión de empleados:
     * mostrarEmpleados()
     * insertarEmpleado(Empleado e, Departamento d)
     * insertaEmpleado()
     * borrarEmpleado(Departamento d, int num_empleado)
     * borrarEmpleado()
     */
    //Método que muestra los empleados de un departamento.
    public void mostrarEmpleados(Departamento d){

        if (empleadosVacios(d) == false){
            for (int i = 0; i < TAM; i++){
                if (d.getEmpleados()[i] != null){
                    if (d.getEmpleados()[i].getDepartamento(d) == d){
                        System.out.println("Empleados: ");
                        System.out.print(" Número del empleado: " + d.getEmpleados()[i].getNum_empleado() + ", ");
                        System.out.print(" Nombre del empleado: " + d.getEmpleados()[i].getNombre() + ", ");
                        System.out.print(" Fecha de alta del empleado: " + d.getEmpleados()[i].getFechaAlta() + ", ");
                        System.out.print(" Salario del empleado: " + d.getEmpleados()[i].getSalario() + ", ");
                        System.out.print(" Departamento al que pertenece: " + d.getEmpleados()[i].getDepartamento(d));
                        System.out.println();
                    }
                }
            }
            System.out.println("Hay " + d.getNumeroEmpleados() + " empleados. ");
            System.out.println("La posicion para insertar es: " + d.getPosicionInserciones());
        }
    }
    //Método que inserta un empleado en un departamento sin interactividad.
    public int insertarEmpleado(Empleado e, Departamento d){

        if (empleadosLleno(d)){
            return -1; //Devuelve -1, si esta lleno el array de empleados.
        }
        else if (existeEmpleado(e.getNum_empleado(),d) >= 0){
            return 0; //Devuelve 0, si ya existe el empleado.
        }else{
            posicionInserciones = d.getPosicionInserciones();
            d.getEmpleados()[posicionInserciones] = e;
            posicionInserciones = buscarHuecosEmpleados(d);
            return 1; //Retorna 1, si se ha insertado correctamente.
        }
    }
    //Método que inserta un empleado en un departamento con interactividad.
    public void insertarEmpleado() throws IOException{

        System.out.println("Seleccione en que departamento quiere insertar un empleado. ");
        int deptInsertar = Integer.parseInt(br.readLine());
        int posDeptInsertar = existeDepartamento(deptInsertar);
        if (posDeptInsertar == -1){
            System.out.println("El departamento elegido no existe. ");
        }else{
            if (empleadosLleno(departamentos[posDeptInsertar])){
                System.out.println("No caben mas empleados en este departamento. ");
            }
            else {
                Empleado emp = null;
                System.out.println("Indique el número del empleado: ");
                int numEmp = Integer.parseInt(br.readLine());
                if (existeEmpleado(numEmp,departamentos[posDeptInsertar]) != -1){
                    System.out.println("Ese empleado ya existe en el departamento. ");
                }
                else {
                    System.out.println("Que quiere insertar:\1 Un analista. \2 Un director." );
                    int tipoEmpleado = Integer.parseInt(br.readLine());
                    System.out.println("Indique el nombre del empleado. ");
                    String nombre = br.readLine();
                    System.out.println("Indique la fecha en la que se le dio de alta al empleado. ");
                    LocalDate fechaAltaEmp = LocalDate.parse(br.readLine());
                    System.out.println("Indique el salario del empledo. ");
                    double salario = Integer.parseInt(br.readLine());
                    if (tipoEmpleado == 1){
                        emp = new Analista(numEmp,nombre,fechaAltaEmp,salario,departamentos[posDeptInsertar]);
                    }else {
                        System.out.println("Indique la comisión del empleado: ");
                        double comisionEmp = Integer.parseInt(br.readLine());
                        emp = new Director(numEmp,nombre,fechaAltaEmp,salario,departamentos[posDeptInsertar],comisionEmp);
                    }
                }
                if (insertarEmpleado(emp,departamentos[posDeptInsertar]) == 1){
                    System.out.println("Se ha insertado el empleado correctamente");
                }
            }
        }

    }
    //Método que borra un empleado del departamento que elijas sin interactividad.
    public int borrarEmpleado(Departamento d, int num_empleado){

        int posicion;

        if (empleadosVacios(d)) {
            return -0; //Devuelve 0, si empleados esta vacío.
        }else{
            if (existeEmpleado(num_empleado,d) < 0) {
                return -1; //Devuelve -1, si no existe el empleado.
            }else{
                posicion = existeEmpleado(num_empleado,d);
                d.getEmpleados()[posicion] = null;
                d.setNumeroEmpleados(3);
                d.setPosicionInserciones(3);
                return 1; //Devuelve 1, si se ha borrado correctamente.
            }
        }
    }
    //Método que borra un empleado del departamento que elijas con interactividad.
    public void borrarEmpleado() throws IOException{

        int eleccionBorrarEmpleado = 0;
        int numeroEmpleado = 0;
        Departamento departamento = null;

        System.out.println("Introduzca el número de empleado que deseas borrar: ");
        try {
            numeroEmpleado = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            menuDepartamentos();
        }
        System.out.println("¿En que departamento esta el empleado que deseas borrar? ");
        int deptBorrar = Integer.parseInt(br.readLine());
        int posDeptBorrar = existeEmpleado(numeroEmpleado,departamentos[deptBorrar]);
        departamento = departamentos[deptBorrar];
        if (borrarEmpleado(departamento,numeroEmpleado) == 1) {
            borrarEmpleado(departamento,numeroEmpleado);
            System.out.println("Se ha borrado el empleado correctamente. ");
        } else {
            System.out.println("No se ha podido borrar por que puede que no exista ningun empleado con ese numero o no hay empleados en ese departamento. ");
        }

    }
    //
    public int modificarNumEmpleado(int num_empleado,int nuevoNum_empleado,Departamento d) {

        int posicion;
        if (existeEmpleado(num_empleado,d) >= 0){
            posicion = existeEmpleado(num_empleado,d);
            departamentos[posicion].getEmpleados()[posicion].setNum_empleado(nuevoNum_empleado);
            return 1;
        }else{
            return -1;
        }

    }
    //
    public void modificarNumEmpleado() throws IOException{

        int nuevoNum_empleado = 0;
        int num_empleado = 0;

        System.out.println("Introduzca el número del empleado que quieras modificar. ");
        try {
            num_empleado = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("Introduzca el nuevo número del empleado. ");
        try {
            nuevoNum_empleado = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("De que departamento quieres modificar el empleado: ");
        int departamento = Integer.parseInt(br.readLine());
        if (modificarNumEmpleado(num_empleado,nuevoNum_empleado,departamentos[departamento]) == 1){
            System.out.println("Se ha modificado correctamente. ");
            mostrarEmpleados(departamentos[departamento]);
        }else{
            System.out.println("No se ha podido modificar por que puede que no exista ningun departamento con ese número. ");
        }
    }
    //
    public int modificarNombreEmpleado(int num_empleado,Departamento d,String nombreEmp){

        int posicion;
        if (existeEmpleado(num_empleado,d) >= 0){
            posicion = existeEmpleado(num_empleado,d);
            departamentos[posicion].getEmpleados()[posicion].setNombre(nombreEmp);
            return 1;
        }else{
            return -1;
        }
    }
    //
    public void modificarNombreEmpleado() throws IOException {

        int num_empleado = 0;

        System.out.println("Introduzca el número del empleado que quieras modificar. ");
        try {
            num_empleado = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("Introduzca el nuevo nombre del empleado. ");
        String nuevoNombre = null;
        try {
            nuevoNombre = br.readLine();
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("De que departamento quieres modificar el empleado: ");
        int departamento = Integer.parseInt(br.readLine());
        if (modificarNombreEmpleado(num_empleado, departamentos[departamento], nuevoNombre) == 1) {
            System.out.println("Se ha modificado correctamente. ");
            mostrarEmpleados(departamentos[departamento]);
        } else {
            System.out.println("No se ha podido modificar por que puede que no exista ningun departamento con ese número. ");
        }
    }
    //
    public int modificarFechaAltaEmp(int num_empleado,Departamento d,LocalDate nuevaFechaAlta){

        int posicion;
        if (existeEmpleado(num_empleado,d) >= 0){
            posicion = existeEmpleado(num_empleado,d);
            departamentos[posicion].getEmpleados()[posicion].setFechaAlta(nuevaFechaAlta);
            return 1;
        }else{
            return -1;
        }

    }
    //
    public void modificarFechaAltaEmp() throws IOException {

        int num_empleado = 0;

        System.out.println("Introduzca el número del empleado que quieras modificar. ");
        try {
            num_empleado = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("Introduzca la nueva fecha de alta del empleado. ");
        LocalDate nuevaFecha = null;
        try {
            nuevaFecha = LocalDate.parse(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("De que departamento quieres modificar el empleado: ");
        int departamento = Integer.parseInt(br.readLine());
        if (modificarFechaAltaEmp(num_empleado, departamentos[departamento], nuevaFecha) == 1) {
            System.out.println("Se ha modificado correctamente. ");
            mostrarEmpleados(departamentos[departamento]);
        } else {
            System.out.println("No se ha podido modificar por que puede que no exista ningun departamento con ese número. ");
        }
    }
    //
    public int modificarSalarioEmpleado(int num_empleado,Departamento d, double salario){

        int posicion;
        if (existeEmpleado(num_empleado,d) >= 0){
            posicion = existeEmpleado(num_empleado,d);
            departamentos[posicion].getEmpleados()[posicion].setSalario(salario);
            return 1;
        }else{
            return -1;
        }
    }
    //
    public void modificarSalarioEmpleado() throws IOException {

        int num_empleado = 0;

        System.out.println("Introduzca el número del empleado que quieras modificar. ");
        try {
            num_empleado = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("Introduzca el nuevo salario del empleado. ");
        double salarioNuevo = 0;
        try {
            salarioNuevo = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("De que departamento quieres modificar el empleado: ");
        int departamento = Integer.parseInt(br.readLine());
        if (modificarSalarioEmpleado(num_empleado, departamentos[departamento], salarioNuevo) == 1) {
            System.out.println("Se ha modificado correctamente. ");
            mostrarEmpleados(departamentos[departamento]);
        } else {
            System.out.println("No se ha podido modificar por que puede que no exista ningun departamento con ese número. ");
        }
    }
    //
    public int modificarDepartamentoEmpleado(int num_empleado,Departamento d,Departamento dNuevo){

        int posicion;
        if (existeEmpleado(num_empleado,d) >= 0){
            posicion = existeEmpleado(num_empleado,d);
            departamentos[posicion].getEmpleados()[posicion].setDepartamento(dNuevo);
            return 1;
        }else{
            return -1;
        }
    }
    //
    public void modificarDepartamentoEmpleado() throws IOException{

        int num_empleado = 0;

        System.out.println("Introduzca el número del empleado que quieras modificar. ");
        try {
            num_empleado = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("Introduzca el nuevo departamento del empleado. ");
        int dNuevo = 0;
        try {
            dNuevo = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo se admiten NÚMEROS. ");
            modificarEmpleados();
        }
        System.out.println("De que departamento quieres modificar el empleado: ");
        int departamento = Integer.parseInt(br.readLine());
        if (modificarDepartamentoEmpleado(num_empleado, departamentos[departamento], departamentos[dNuevo]) == 1) {
            System.out.println("Se ha modificado correctamente. ");
            mostrarEmpleados(departamentos[departamento]);
        } else {
            System.out.println("No se ha podido modificar por que puede que no exista ningun departamento con ese número. ");
        }
    }
    /**
     * Métodos de ayuda:
     * existeEmpleado(int num_empleado, Departamento d)
     * empleadosVacios(Departamento d)
     * empleadosLLenos(empleadosVacios(Departamento d))
     * buscarHuecos()
     * existeDepartamento(int dept_no)
     * departamentosLLeno()
     * departamentosVacios()
     */
    //Método que mira si existe el empleado en el departamento que se le pasa como argumento mediante su número de empleado.
    public int existeEmpleado(int num_empleado, Departamento d) {

        boolean encontrado = false;
        int contador = 0;

        do{
            if (d.getEmpleados()[contador] != null && d.getEmpleados()[contador].getNum_empleado() == num_empleado){
                encontrado = true;
            }else contador++;
        }while (!encontrado && contador < TAM);

        if (encontrado) return contador;
        else return -1;
    }
    //Método que mira si el array de empleados está vacío.
    public boolean empleadosVacios(Departamento d){

        return (d.getNumeroEmpleados() == 0);
    }
    //Método que mira si el array de empleado está lleno.
    public boolean empleadosLleno(Departamento d){

        return (d.getNumeroEmpleados() == TAM);

    }
    //Método que busca los huecos libres en los departamentos.
    public int buscarHuecosDepartamentos(){

        boolean encontrado = false;
        int contador = 0;

        while (!encontrado && contador < TAM){
            if (departamentos[contador] == null){
                encontrado = true;
            }else contador++;
        }
        if (encontrado) return contador;
        else return -1;
    }
    //Método que busca los huecos libres en los empleados.
    public int buscarHuecosEmpleados(Departamento d) {

        boolean encontrado = false;
        int contador = 0;

        while (!encontrado && contador < TAM){
            if (d.getEmpleados()[contador] == null){
                encontrado = true;
            }else contador++;
        }
        if (encontrado) return contador;
        else return -1;
    }
    //Método que mira si existe el departamento que se le pasa como argumento mediante su número de departamento.
    public int existeDepartamento(int dept_no){

        boolean encontrado = false;
        int contador = 0;

        do{
            if (departamentos[contador] != null && departamentos[contador].getDept_no() == dept_no){
                encontrado = true;
            }
            else contador++;
        }while (!encontrado && contador < TAM);

        if (encontrado) return contador;
        else return -1;
    }
    //Método que mira si el array de departamentos está lleno.
    public boolean departamentosLleno(){

        if (TAM == numeroDepartamentos){
            return true;
        }
        else return false;
    }
    //Método que mira si el array de departamentos está vacío.
    public boolean departamentosVacios(){

        if (numeroDepartamentos == 0){
            return true;
        }
        else return false;
    }
    //Método que busca un departamento por su nombre.
    public int buscarDepartamento(String nombreDepartamento){

        boolean encontrado = false;
        int contador = 0;

        do{
            if (departamentos[contador] != null && departamentos[contador].getNombre() == nombreDepartamento){ //Compara el nombre de los departamentos ya existentes con el que le pasas como argumento.
                encontrado = true;
            }
            else contador++;
        }while (!encontrado && contador < TAM);

        if (encontrado) return contador; //Si está el departamento retorna la posicion donde se encuentra el departamento.
        else return -1; //Devuelve -1 si no encuentra al departamento.

    }
    //Método que busca un departamento por su nombre interactivo. MIRAR POR QUE NO FUNCIONA.
    public void buscarDepartamento() throws IOException{

        System.out.println("Introduzca el nombre del departamento que quieres buscar. ");
        String dNombre = br.readLine();

        if (buscarDepartamento(dNombre) == -1){
            System.out.println("Ese departamento no existe");
        }else{
            System.out.println("La posicion en la que se encuentra el departamento buscado es " + buscarDepartamento(dNombre));
        }
    }

//FIN CLASE
}
