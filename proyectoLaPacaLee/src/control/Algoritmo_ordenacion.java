package control;

public class Algoritmo_ordenacion {

		public  void imprimirArray (String lista[]){
			for(int i=0;i<lista.length;i++){
				System.out.println(lista[i]);
			}
		}


		public  void quicksortP (String lista1[], int izq, int der){
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








		public void OrdenarQicksort(int[] array) 
		{
			array = quicksort1(array);

		}
		public int[] quicksort1(int numeros[])
		{
			return quicksort2 (numeros, 0, numeros.length-1);
		}
		public int[] quicksort2 (int numeros[],int izq,int der)
		{
			if(izq>=der)
				return numeros;
			int i=izq, d=der;
			if(izq!=der)
			{	
				int pivote;
				int aux;
				pivote = izq;
				while(izq!=der)
				{
					while(numeros[der]>=numeros[pivote] && izq<der)
						der--;
					while(numeros[izq]<numeros[pivote] && izq<der)
						izq++;
					if (der!=izq)
					{
						aux = numeros[der];
						numeros[der]=numeros[izq];
						numeros[izq]=aux;}
				}
				if (izq==der) {
					quicksort2(numeros,i,izq-1);
					quicksort2(numeros,izq+1,d);
				}
			}
			else
				return numeros;
			return numeros;
		}
	}
