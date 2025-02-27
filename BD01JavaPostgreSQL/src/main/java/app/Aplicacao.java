package app;

import java.util.List;

import dao.DAO;
import dao.CarroDAO;
import model.Carro;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		CarroDAO carroDAO = new CarroDAO();
		
		System.out.println("\n\n==== Inserir carro === ");
		Carro carro = new Carro(1, "Ford", "Mustang", 2020, 'G');
		if(carroDAO.insert(carro)) {
			System.out.println("Inserção com sucesso -> " + carro.toString());
		}
		
		System.out.println("\n\n==== Testando autenticação (marca e modelo) ===");
		System.out.println("Carro (" + carro.getMarca() + " - " + carro.getModelo() + "): " + carroDAO.autenticar("Ford", "Mustang"));
			
		System.out.println("\n\n==== Mostrar carros por tipo de combustível (Gasolina) === ");
		List<Carro> carros = carroDAO.getCarrosPorCombustivel('G');
		for (Carro c: carros) {
			System.out.println(c.toString());
		}

		System.out.println("\n\n==== Atualizar ano do carro (código " + carro.getCodigo() + ") === ");
		carro.setAno(2021);
		carroDAO.update(carro);
		
		System.out.println("\n\n==== Testando autenticação após atualização ===");
		System.out.println("Carro (" + carro.getMarca() + " - " + carro.getModelo() + "): " + carroDAO.autenticar("Ford", "Mustang"));		
		
		System.out.println("\n\n==== Mostrar carros ordenados por código === ");
		carros = carroDAO.getOrderByCodigo();
		for (Carro c: carros) {
			System.out.println(c.toString());
		}
		
		System.out.println("\n\n==== Excluir carro (código " + carro.getCodigo() + ") === ");
		carroDAO.delete(carro.getCodigo());
		
		System.out.println("\n\n==== Mostrar carros ordenados por marca === ");
		carros = carroDAO.getOrderByMarca();
		for (Carro c: carros) {
			System.out.println(c.toString());
		}
	}
}