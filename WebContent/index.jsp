<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:include page="./template/head.jsp"></jsp:include>

<!-- Conteúdo principal -->
<body>
	<div class="jumbotron">
		<h1 class="welcome" style="color: #787a89;">Bem-vindo ao Sabor e Preparo!</h1>
		<hr/>
		<!-- Título principal -->
<!-- 		<img style="width: 330px; height: 300px;" class="logoEmpresa img-responsive" id="logoEmpresa" src="img/faenfinobg.png" alt="FAENFI">  -->
<!-- 		<img class="logoEmpresa img-responsive" src="img/agesnobg.png" alt="AGES"> -->
		<input type="hidden" id="idEmpresa" value="25" />

		<div class="container">
			<div class="panel panel-success panel-about">
				<h2 class="text-center" style="color: #c0ce73;"> Sobre o projeto</h2>
				<div class="panel-body">
					<h4 class="text-center" style="color: #e4a911; margin-top: 30px;">História</h4>
					<hr class="gradient"/>
					<span>
						O projeto da Ficha Técnica de Preparo (codinome do sistema) teve início na disciplina de Prática na Agência Experimental I, do curso de
						Bacharelado em Engenharia de Software da Faculdade de Informática/PUCRS em parceria com a Faculdade de Nutrição/PUCRS no segundo semestre de 2016.</br></br>
						O objetivo das disciplinas de Prática na Agência Experimental é proporcionar aos estudantes de Engenharia de Software a oportunidade de vivenciar
						uma experiência real na área de desenvolvimento de software através de projetos e dinâmicas reais, simulando, em alguns aspectos o ambiente de uma empresa.</br></br>
						O Sabor e Preparo é uma aplicação web responsiva com funcionalidades para criar fichas técnicas de preparo, que tem como o seu objetivo a
						padronização de receitas referente a custo, porcionamento, modo de preparo, apresentação e rendimento.
					</span>

					<h4 class="text-center" style="color: #e4a911; margin-top: 30px;">Time</h4>
					<hr class="gradient"/>
					<table style="width: 100%;">
						<tr>
							<td width="33%"></td>
							<td width="33%"><h2 style="margin-left: 25%;">2016/2</h2></td>
							<td width="33%"><h2 style="margin-left: 25%;">2017/2</h2></td>
						</tr>
						<tr>
							<td align="center" width="33%"><img class="logosAbout" src="img/logo_FACIN.jpg" width="150" alt="FACIN"></td>
							<td width="33%">
								<ul>
									<li class="item1">Alessandro Medeiros</li>
									<li class="item2">Felipe Nunes</li>
									<li class="item3">Guilherme Paris</li>
									<li class="item4">Guilherme Kilpp</li>
									<li class="item5">Homero Santos</li>
									<li class="item6">Iann Müller</li>
									<li class="item7">João M. Fantin</li>
									<li class="item8">Lucas Soares</li>
									<li class="item9">Lucas Ribeiro</li>
									<li class="item10">Luis Santana</li>
									<li class="item11">Ricardo Borges</li>
									<li class="item12">Rodrigo Baldi</li>
									<li class="item14">Cássio Trindade</li>
									<li class="item15">Professora Alessandra Dutra</li>
								</ul>
							</td>
							<td width="33%">
								<ul>
									<li class="item1">Max Zorzetti</li>
									<li class="item2">Leonardo Veiga</li>
									<li class="item3">Matheus Ferreira</li>
									<li class="item4">Matheus Lagreca</li>
									<li class="item5">Thiago Carreira</li>
									<li class="item6">Jean Bainha</li>
									<li class="item7">Fernando Maioli</li>
									<li class="item8">Marcelo Azevedo</li>
									<li class="item9">Guilherme Piccoli</li>
									<li class="item10">Gabriel Brunichaki</li>
									<li class="item11">Phillip Mittmann</li>
									<li class="item12">Victoria Azevedo</li>
									<li class="item14">Cássio Trindade</li>
									<li class="item15">Professor Azriel Majdenbaum</li>
								</ul>
							</td>
						</tr>
						<tr>
							<td align="center" width="33%"><img class="logosAbout" id="logoEmpresa" src="img/faenfinobg.png" width="200px" alt="FAENFI"></td>
							<td width="33%">
								<ul>
									<li class="item1">Rayza Camillo</li>
									<li class="item2">Taiane Sandi</li>
									<li class="item3">Professora Ana Feoli</li>
									<li class="item4">Professora Luisa Rihl</li>
								</ul>
							</td>
							<td width="33%">
								<ul>
									<li class="item1">Gabriéli Machado</li>
									<li class="item2">Gabrielle Noya</li>
									<li class="item3">Professora Luísa Castro</li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div style="text-align: center;">
			<img class="logoEmpresa img-responsive" src="img/agesnobg.png" alt="AGES">
		</div>
	</div>

</body>


<jsp:include page="./template/foot.jsp"></jsp:include>