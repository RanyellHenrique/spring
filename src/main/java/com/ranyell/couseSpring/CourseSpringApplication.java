package com.ranyell.couseSpring;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ranyell.couseSpring.domain.Categoria;
import com.ranyell.couseSpring.domain.Cidade;
import com.ranyell.couseSpring.domain.Cliente;
import com.ranyell.couseSpring.domain.Endereco;
import com.ranyell.couseSpring.domain.Estado;
import com.ranyell.couseSpring.domain.Pagamento;
import com.ranyell.couseSpring.domain.PagamentoComBoleto;
import com.ranyell.couseSpring.domain.PagamentoComCartao;
import com.ranyell.couseSpring.domain.Pedido;
import com.ranyell.couseSpring.domain.Produto;
import com.ranyell.couseSpring.domain.enums.EstadoPagamento;
import com.ranyell.couseSpring.domain.enums.TipoCliente;
import com.ranyell.couseSpring.repositories.CategoriaRepository;
import com.ranyell.couseSpring.repositories.CidadeRepository;
import com.ranyell.couseSpring.repositories.ClienteRepository;
import com.ranyell.couseSpring.repositories.EnderecoRepository;
import com.ranyell.couseSpring.repositories.EstadoRepository;
import com.ranyell.couseSpring.repositories.PagamentoRepository;
import com.ranyell.couseSpring.repositories.PedidoRepository;
import com.ranyell.couseSpring.repositories.ProdutoRepository;

@SpringBootApplication
public class CourseSpringApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourseSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est2);
		Cidade c2 = new Cidade(null, "São Paulo", est1);
		Cidade c3 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(c2, c3));
		est2.getCidades().addAll(Arrays.asList(c1));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria", "Maria123@gmail.com", "061.870.221.32", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("(61)3358-8092", "(61)992728-2930"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apt 203", "Jardim", "73320812", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 108", "Centro", "17022199", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("17/10/2017 09:30"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	}

}
