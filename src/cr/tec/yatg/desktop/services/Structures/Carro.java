package Structures;


public class Carro implements Comparable<Carro>{
		private int placa;
		private String marca;
		private Importancia importancia;
		
		public Carro(int placa, String marca, Importancia importancia) {
			super();
			this.placa = placa;
			this.marca = marca;
			this.importancia=importancia;
		}
		public int getPlaca() {
			return placa;
		}
		public void setPlaca(int placa) {
			this.placa = placa;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		
		
		public Importancia getImportancia() {
			return importancia;
		}
		public void setImportancia(Importancia importancia) {
			this.importancia = importancia;
		}
		@Override
		public int compareTo(Carro o) {
			return this.importancia.compareTo(o.importancia);
		}
		 public enum Importancia {
			taxi(1), uber(2), patrulla(3), particular(4);
			private int value;

			private Importancia(int value) {
				this.value = value;
			}

		}
}
