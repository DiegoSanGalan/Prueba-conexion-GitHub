package cajondesastre;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class OrdenarPorEdad implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		int comparador = 0;
		Persona p1 = null;
		Persona p2 = null;
		p1 = (Persona) arg0;
		p2 = (Persona) arg1;
		//System.out.println(arg0== arg1); 
//System.out.println("PASA POR COMPARE ORDENAR POR EDAD");
		if (p1.getEdad() < p2.getEdad())
		{
			
			comparador = -1;
		}
		else {
			if (p1.getEdad()> p2.getEdad())
			{
				
				comparador = 1;
			}else {
				
				comparador = 0;
			}
		}
		
		// se podría hacer asi porque si restamos la edad del primero a la edad del segundo
		//  y da un numero negativo quiere decir que el segundo es mayor,
		//  si da un numero positivo quiere decir que el primero es mayor.
		//  y si sale 0 es que tienen la misma edad.
		// no es necesario que sea -1 0 y +1 lo que admite es un numero negativo un positivo o 0.
		comparador = p1.getEdad()-p2.getEdad();
		
		return comparador;
		
	}
/*
	@Override
	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0, Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> comparingLong(ToLongFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> nullsFirst(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T> Comparator<T> nullsLast(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparing(Comparator arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparing(Function arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparing(Function arg0, Comparator arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparingDouble(ToDoubleFunction arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparingInt(ToIntFunction arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator thenComparingLong(ToLongFunction arg0) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
