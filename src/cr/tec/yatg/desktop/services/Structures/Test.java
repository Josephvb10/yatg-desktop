package cr.tec.yatg.desktop.services.Structures;

import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		PriorityQueue<Carro> colaPrioridad = new PriorityQueue<>();
		Carro carro1 = new Carro(9090, "toyota", Carro.Importancia.patrulla);
		Carro carro2 = new Carro(1212, "nissan", Carro.Importancia.taxi);
		Carro carro3 = new Carro(6767, "Hummer", Carro.Importancia.uber);
		Carro carro4 = new Carro(2323, "jeep", Carro.Importancia.patrulla);
		colaPrioridad.add(carro1);
		colaPrioridad.add(carro2);
		colaPrioridad.add(carro3);
		colaPrioridad.add(carro4);
		while(colaPrioridad.size()>0){
			System.out.println(colaPrioridad.poll().getMarca());
		}
		int positionX= 1;
		int positionY= 2;
		Item item1 = new Item(ItemType.bomb, positionX, positionY);
		Item item2 = new Item(ItemType.turbo, positionX, positionY);
		Item item3 = new Item(ItemType.fuel, positionX, positionY);
		Item item4 = new Item(ItemType.shield, positionX, positionY);
		Item item5 = new Item(ItemType.bomb, positionX, positionY);
		System.out.println(item1.getValue());
		System.out.println(item2.getValue());
		System.out.println(item3.getValue());
		System.out.println(item4.getValue());
		System.out.println(item5.getValue());


		ItemsPriorityQueue colatest =  new ItemsPriorityQueue();
		colatest.add(item1);
		colatest.add(item2);
		colatest.add(item3);
		colatest.add(item4);
		colatest.add(item5);
		while(!colatest.isEmpty()){
			System.out.println(colatest.poll().getType());
			
		}
	}

}
