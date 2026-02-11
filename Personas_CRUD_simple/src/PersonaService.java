import java.util.Scanner;
public class PersonaService {
    public void alta(Scanner sc , Personas[] personas){
        System.out.println("Dame el Id");
        int id= sc.nextInt();//validar que no sea 0 y que sea numerico

        System.out.println("Dame el nombre");
        String name= sc.nextLine(); //Validar que el nombre no este vacio
        if(verificarIdRepetido(id, personas)){
            System.out.println("El id Esta repetido");
            return;
        }
        Personas p1= new Personas(id,name);
        int indice=obtenerIndice(personas);
        if(indice==-1){
            System.out.println("El arreglo esta lleno");
            return;
        }
        personas[indice]=p1;



    }

    public boolean verificarIdRepetido(int id, Personas[]personas){
        for(Personas p: personas){
            if( id==p.getId()){
                return true;
            }
        }
        return false;
    }

    public int obtenerIndice(Personas[]personas){
        for (int i = 0; i < personas.length; i++) {
            if(personas[i]==null){
                return i;
            }
        }
        return -1;

    }

}


