<h1>
	<span style="color:orange;">TesteDeAutomacaoJava</span>
</h1>

Esse foi um desafio enviado pela CI&T durante o curso de ADS "Teste de Automação para QA - CI&T".

https://bitbucket.org/dhiego_ciandt/qa-test/src/main/

Foram criados 3 casos de testes utilizando o Selenium e JAVA.

Teste QA1<br/>
<b>Funcionalidade:</b> Busca no Banco de Questões<br/>
<b>Cenário:</b> Busca por questão inexistente<br/>
<b>Dado</b> que navego para a página de busca do banco de questões<br/>
<b>E</b> digito "Science: Computers" no campo de busca<br/>
<b>Quando</b> clico no botão de buscar<br/>
<b>Então</b> visualizo uma mensagem de erro com o texto "No questions found."<br/><br/>

Teste QA2<br/>
<b>Funcionalidade:</b> Busca no Banco de Questões <br/>
<b>Cenário:</b> Busca por questão passando como parâmetro a <b>categoria</b> <b>"Science: Computers"</b><br/>
<b>Dado</b> que navego para a página de busca do banco de questões<br/>
<b>E</b> digito "Science: Computers" no campo de busca, como também seleciono o tipo de busco por categoria<br/>
<b>Quando</b> clico no botão de buscar<br/>
<b>Então</b> visualizo uma lista com 25 itens como também seu controle de paginação<br/><br/>

Teste QA3<br/>
<b>Funcionalidade:</b> Busca no Banco de Questões <br/>
<b>Cenário:</b> Busca por questão passando como parâmetro a <b>usuário</b> <b>"Coldflame"</b><br/>
<b>Dado</b> que navego para a página de busca do banco de questões<br/>
<b>E</b> digito "Coldflame" no campo de busca, como também seleciono o tipo de busco por usuário<br/>
<b>Quando</b> clico no botão de buscar<br/>
<b>Então</b> visualizo uma lista com 8 itens, em seguida clico no link "Coldflame" e valido se o número total de 
retorno de questão pelo usuário confere com os listados nas duas páginas apresentadas.<br/><br/>
