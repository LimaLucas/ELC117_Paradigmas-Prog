/* Olimpíada Brasileira de Informática – OBI2013
 * 
 * Questão: No país das maravilhas
 *
 * Uma  companhia  de  teatro  está  iniciando  os  ensaios  para  uma  
 * nova versão  de  Alice  no  País  das Maravilhas. 
 * Oito meninas, Lia, Mel, Nanda, Olga, Pilar, Rute, Sara e Tina, 
 * disputam o papel de Alice, e vão realizar um teste para determinar
 * qual é a escolhida. Os testes, com duração de uma hora, serão feitos
 * de segunda-feira a sexta-feira, em dois horários, 8:00 e 9:00 horas. 
 * Uma menina será testada por vez, mas nenhuma menina será testada no 
 * horário de quarta-feira 8:00, pois já há uma reunião do resto do 
 * elenco marcada para esse dia e horário. 
 * 
 * As seguintes condições devem ser obedecidas:
 *	- Sara é testada terça-feira, 9:00.
 *	- Pilar deve ser testada em algum momento antes de Nanda.
 *	- Olga deve ser testada no mesmo dia que Mel.
 *	- Se Lia é testada às 8:00 em algum dia, então Rute é testada às 8:00 
 *    em outro dia.
 */

%% ------------------------------------------

/*verificaTestes([(M,D,H)|T]) :- 
	member((M,D,H),T) \== true,	
	verificaMenina(M,T), 
	verificaTestes(T).

verificaMenina(M,[(M1,D,H)|T]) :-
	M \== M1, verificaMenina(M,T).*/

dia(seg, 1).
dia(ter, 2).
dia(qua, 3).
dia(qui, 4).
dia(sex, 5).

antes((_,D1,H1),(_,D2,H2)) :- dia(D1,N1), dia(D2,N2), (N1<N2; (N1=N2, H1<H2)).

mesmoDia((_,D,_),(_,D,_)).

mesmaHora((_,D1,8),(_,D2,8)) :- D1 \== D2.
mesmaHora((_,_,9),(_,_,_)).

solucao(Testes) :- 
	Testes = [_, _, _, _, _, _, _, _],

    member(teste(_,seg,8), Testes),
    member(teste(_,seg,9), Testes),
    member(teste(_,ter,8), Testes),
    member(teste(sara,ter,9), Testes),
    member(teste(nenhuma,qua,8), Testes),
    member(teste(_,qua,9), Testes),
    member(teste(_,qui,8), Testes),
    member(teste(_,qui,9), Testes),
    member(teste(_,sex,8), Testes),
    member(teste(_,sex,9), Testes),

    member(teste(pilar, _, _), Testes),
    member(teste(nanda, _, _), Testes),
    antes(teste(pilar, _, _),teste(nanda, _, _)),
    member(teste(olga, _, _), Testes),
    member(teste(mel, _, _), Testes),
    mesmoDia(teste(olga, _, _),teste(mel, _, _)),
    member(teste(tina, _, _), Testes),
    member(teste(lia, _, _), Testes),
    member(teste(rute, _, _), Testes),
    mesmaHora(teste(lia, _, _),teste(rute, _, _)),
    member(teste(rute, _, _), Testes),
    member(teste(nenhuma2, _, _), Testes).

/*
Consulta teste para questão 19: 
member((rute, seg, 8), solucao(T)), member((tina, ter, 8), solucao(T)), member((pilar, qui, 8), solucao(T)), member((mel, sex, 8), solucao(T)).
*/
%% ------------------------------------------

/* QUESTÕES ---------------------------------
 *
 * QUESTÃO 19. Qual das alternativas seguintes poderia ser uma lista 
 * completa e correta das meninas testadas no horário das 8:00, 
 * de segunda a sexta-feira? 
 * R = D. (Rute, Tina, nenhuma, Pilar, Mel.)
 *
 * QUESTÃO 20. Se Nanda é testada sexta-feira, 8:00, qual é o dia 
 * e horário mais tarde na semana em que Mel poderia ser testada?
 * R = C. (Quinta-feira, 9:00)
 * 
 * QUESTÃO 21. Se Tina e Nanda são testadas em algum momento antes 
 * de Sara, qual das seguintes alternativas não pode ser verdadeira?
 * R = C. (Lia é testada quinta-feira, 8:00.)
 *
 * QUESTÃO 22. Se  Nanda  e  Olga  são  testadas  em algum  momento
 * antes  de  Tina,  qual  é  o  dia  e horário mais cedo na semana 
 * em que Tina pode ser testada?
 * R = A. (Quinta-feira, 8:00)
 *
 * QUESTÃO 23. Se  nenhuma  menina  é  testada  na quinta-feira, 8:00,
 * qual das seguintes alternativas poderia ser verdadeira?
 * R = D. (Lia é testada terça-feira, 8:00 e Olga é testada em algum 
 *         momento antes de Rute.)
 * 
 * QUESTÃO 24. Se  Rute  é  testada  na  quinta-feira, 8:00 e Tina é 
 * testada na sexta-feira, 8:00, qual das seguintes alternativas 
 * poderia ser verdadeira?
 * R = B. (Lia é testada na quarta-feira, 9:00.)
 *
 */