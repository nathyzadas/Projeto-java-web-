package br.com.ProjetoCRUD.entidades;

public class Servico {
	
		private int idServico;
		public String nomeServico;
		public String fotoServico;
		public String descServico;
		

		public int getIdServico() {
			return idServico;
		}

		public void setIdServico(int idServico) {
			this.idServico = idServico;
		}

		public String getNomeServico() {
			return nomeServico;
		}

		public void setNomeServico(String nomeServico) {
			this.nomeServico = nomeServico;
		}
		
		public String getFotoServico() {
			return fotoServico;
		}

		public void setFotoServico(String fotoServico) {
			this.fotoServico = fotoServico;
		}

		public String getDescServico() {
			return descServico;
		}

		public void setDescServico(String descServico) {
			this.descServico = descServico;
		}

		

		public Servico(String nomeServico, String fotoServico, String descServico) {
			super();

			this.nomeServico = nomeServico;
			this.fotoServico = fotoServico;
			this.descServico = descServico;
		}

		public Servico() {
			super();
			// TODO Auto-generated constructor stub
		}

	

}
