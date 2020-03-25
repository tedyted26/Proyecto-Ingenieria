package control;

public class Odenacion {

	public static void main(String[] args) {

		int []arreglo = {5,11,45,3,79,80};


		Algoritmo_ordenacion o = new Algoritmo_ordenacion();

		String lista_String[]={"americano", "americano", "pedro", "Tocado", "coz","azul", "americano"};

		//ordenamos el array
		quicksortP(lista_String, 0, lista_String.length-1);

		System.out.println("Array de String ordenado:");
		imprimirArray(lista_String);

		o.OrdenarQicksort(arreglo);

		for(int i=0;i<arreglo.length;i++)
		{
			System.out.println(arreglo[i]);
		}

	}

	public  static void imprimirArray (String lista[]){
		for(int i=0;i<lista.length;i++){
			System.out.println(lista[i]);
		}
	}


	public static  void quicksortP (String lista1[], int izq, int der){
		int i=izq;
		int j=der;
		int pivote=(i+j)/2;
		do {
			while (lista1[i].compareToIgnoreCase(lista1[pivote])<0){
				i++;
			}
			while (lista1[j].compareToIgnoreCase(lista1[pivote])>0){
				j--;
			}
			if (i<=j){
				String aux=lista1[i];
				lista1[i]=lista1[j];
				lista1[j]=aux;
				i++;
				j--;
			}
		}while(i<=j);
		if (izq<j){
			quicksortP(lista1, izq, j);
		}
		if (i<der){
			quicksortP(lista1, i, der);
		}
	}


}
