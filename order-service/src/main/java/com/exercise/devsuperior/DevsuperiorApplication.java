package com.exercise.devsuperior;

import com.exercise.devsuperior.entities.Order;
import com.exercise.devsuperior.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DevsuperiorApplication implements CommandLineRunner {

	private final OrderService orderService;

	public DevsuperiorApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DevsuperiorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Código do pedido: ");
			int code = sc.nextInt();

			System.out.print("Valor básico: ");
			double basic = sc.nextDouble();

			System.out.print("Desconto (%): ");
			double discount = sc.nextDouble();

			if (code <= 0 || basic < 0 || discount < 0 || discount > 100) {
				System.out.println("Erro: Valores inválidos!");
				return;
			}

			Order order = new Order(code, basic, discount);

			System.out.println("\n--- Resumo do Pedido ---");
			System.out.println("Pedido código: " + code);
			System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));

		} catch (InputMismatchException e) {
			System.out.println("Erro: Entrada inválida!");
		}
	}
}